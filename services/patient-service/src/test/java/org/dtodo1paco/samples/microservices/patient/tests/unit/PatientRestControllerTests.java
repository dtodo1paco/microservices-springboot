/**
 * 
 */
package org.dtodo1paco.samples.microservices.patient.tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.dtodo1paco.samples.microservices.patient.domain.Patient;
import org.dtodo1paco.samples.microservices.patient.tests.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author pac
 *
 */
public class PatientRestControllerTests extends AbstractTest {
	
	private static final String API_BASE = "/patients";
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getList() throws Exception {
		String uri = API_BASE;
		MvcResult mvcResult = mvc.perform(
			MockMvcRequestBuilders
				.get(uri)
					.accept(MediaType.APPLICATION_JSON_VALUE)
		).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Patient[] list = mapFromJson(content, Patient[].class);
		assertTrue(list.length > 0);
	}

	@Test
	public void createItem() throws Exception {
		String uri = API_BASE;
		Patient item = new Patient();
		item.setId((long) 3);
		item.setFamilyName("Marlon");
		item.setGivenName("Newman");
		String inputJson = super.mapToJson(item);
		MvcResult mvcResult = mvc.perform(
			MockMvcRequestBuilders
				.post(uri)
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(inputJson)
		).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		// Patient res = mapFromJson(content, Patient.class);
		assertTrue(content.contains("Marlon"));
	}
/*
	@Test
	public void updateProduct() throws Exception {
		String uri = "/products/2";
		Product product = new Product();
		product.setName("Lemon");
		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is updated successsfully");
	}

	@Test
	public void deleteProduct() throws Exception {
		String uri = "/products/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is deleted successsfully");
	}
	*/
}
