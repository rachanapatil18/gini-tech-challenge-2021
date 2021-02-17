package net.gini.challenge.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import net.gini.challenge.model.Documents;
import net.gini.challenge.repository.DocmuentsRepository;
import net.gini.challenge.vo.DocumentsJson;

/**
 * 
 * @author Rachana Service for Retrieve null Serial number and updated Documents
 *
 */
@Service
public class DocumentsServiceRunner implements DocumentsService {

	@Value("${client.api.uri}")
	String url;

	@Autowired
	DocmuentsRepository documentRepo;

	@Autowired
	RestTemplate restTemplate;

	Logger LOG = LoggerFactory.getLogger(DocumentsServiceRunner.class);

	private static final String PROCESSING_STATUS_OK = "OK";

	@Override
	public List<Documents> retrieveAllDocuments() {
		List<Documents> documentsList = documentRepo.findAll();

		List<Documents> docsWithoutSerialNumList = new ArrayList<>();

		documentsList.forEach(documents -> {
			if (documents.getSerial_number() == null) {
				docsWithoutSerialNumList.add(documents);
				LOG.info("Document Id {}", documents.getId(), "Serial Number {}", documents.getSerial_number());
			}
		});
		return docsWithoutSerialNumList;
	}

	@Override
	public void persistSerialNum(List<Documents> docList) {

		docList.forEach(doc -> {
			if (isNullOrEmpty(doc.getSerial_number())) {
				DocumentsJson docResponse = callExternalClient(doc.getId());
				if (docResponse.getProcessing_status().equals(PROCESSING_STATUS_OK)) {
					LOG.info("Documents are updating with Processing Status");
					doc.setSerial_number(docResponse.getInvoice_id());
					documentRepo.save(doc);
					LOG.info("*************Document Updated**************************************");
				} else {
					LOG.info("PROCESSING_STATUS {}", docResponse.getProcessing_status());
					LOG.info("Documents Not updated {}", docResponse.getInvoice_id());
					LOG.info("***************************************************");
				}
			}
		});
	}

	// Connect to external APIs
	private DocumentsJson callExternalClient(Long id) {
		DocumentsJson docResponse = restTemplate.getForObject(url + "/" + id, DocumentsJson.class);
		LOG.info("***************************************************");
		LOG.info("Invoice ID from external Client {}", docResponse.getInvoice_id());
		LOG.info("Processing Status {}", docResponse.getProcessing_status());
		LOG.info("***************************************************");
		return docResponse;
	}
	
	//Null and Empty check
	private boolean isNullOrEmpty(String serialNum) {
        if(serialNum != null && !serialNum.isEmpty())
            return false;
        return true;
    }

}
