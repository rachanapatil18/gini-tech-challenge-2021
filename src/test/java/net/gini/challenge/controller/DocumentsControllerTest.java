package net.gini.challenge.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import net.gini.challenge.service.DocumentsService;

public class DocumentsControllerTest {

	private DocumentsController docController;
	private DocumentsService documentsService;
	private MockMvc mockMvc;

	public DocumentsControllerTest() {
		documentsService = Mockito.mock(DocumentsService.class);
		docController = Mockito.mock(DocumentsController.class);
	}

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(docController).build();
	}

	@Test
	public void retriveAllDocumentsTest() throws Exception {
		String uri = "/gini-tech/documents";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
}
