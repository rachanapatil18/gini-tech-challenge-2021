package net.gini.challenge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.gini.challenge.model.Documents;
import net.gini.challenge.service.DocumentsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentsTest {

	@Autowired
	DocumentsService documentsService;
	List<Documents> documentList = new ArrayList<>();

	@Test
	public void retrieveDocumentsTest() throws Exception {
		List<Documents> allDocuments = documentsService.retrieveAllDocuments();
		Assert.assertNotNull(allDocuments);

	}

	@Test
	public void persistSerialNumTest() throws Exception {
		documentsService.persistSerialNum(documentList);
		Assert.assertTrue("Documents updated with serial number", Boolean.TRUE);
	}

}
