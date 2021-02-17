/**
 * 
 */
package net.gini.challenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.gini.challenge.exceptions.DataCommunicationException;
import net.gini.challenge.model.Documents;
import net.gini.challenge.service.DocumentsService;
/**
 * @author Rachana
 *
 */

@RestController
@RequestMapping("/gini-tech")
public class DocumentsController extends CustomizedResponseEntityExceptionHandler{
	
	@Autowired
	DocumentsService documentsService;
	
	@Value("${message.success}")
	String message;
	
	Logger LOG = LoggerFactory.getLogger(DocumentsController.class);
	 
	@GetMapping("/documents")
	public String retriveAllDocuments() throws DataCommunicationException{
		List<Documents> retrieveAllDocuments = documentsService.retrieveAllDocuments();
		 documentsService.persistSerialNum(retrieveAllDocuments);
		 return message;
	}
}
