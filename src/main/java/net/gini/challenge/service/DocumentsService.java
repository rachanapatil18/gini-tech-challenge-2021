/**
 * 
 */
package net.gini.challenge.service;

import java.util.List;

import net.gini.challenge.model.Documents;

/**
 * @author Rachana
 *
 */
public interface DocumentsService {
	
	public List<Documents> retrieveAllDocuments();
	
	public void persistSerialNum(List<Documents> docList);

}
