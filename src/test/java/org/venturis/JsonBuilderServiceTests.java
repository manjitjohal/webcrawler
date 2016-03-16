package org.venturis;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.venturis.domain.Product;
import org.venturis.service.JsonBuilderService;

/**
 * Tests for {@link JsonBuilderService}.
 *
 * @author Manjit Johal
 */
public class JsonBuilderServiceTests {


	@Autowired
	private JsonBuilderService jsonBuilderService;
	
	
	@Before
	public void init() {
		jsonBuilderService = new JsonBuilderService();
	}

	
	@Test
	public void testEmptyCollection() throws Exception {
		List<Product> products = new ArrayList<Product>();
		String response = jsonBuilderService.buildJSON(products);
		
		assertThat(response).isEmpty();
	}

	@Test
	public void testResponseStructure() throws Exception {
		List<Product> products = new ArrayList<Product>();
		
		Product prod1 = new Product("www.google.com", "title", 22);
		prod1.setDescription("description");
		prod1.setPageSize(22);	
		
		products.add(prod1);
		
		String response = jsonBuilderService.buildJSON(products);
		
		assertThat(response).contains("results");
		assertThat(response).contains("unit_price");
		assertThat(response).contains("size");
		assertThat(response).contains("title");
		assertThat(response).contains("description");
		assertThat(response).contains("total");
		assertThat(response).contains("\"total:\" 22.0");
	}

	@Test
	public void testMultipleProducts() throws Exception {
		List<Product> products = new ArrayList<Product>();
		
		Product prod1 = new Product("www.google.com", "google homepage", 22);
		prod1.setDescription("this is the place to search");
		prod1.setPageSize(22);			
		products.add(prod1);
		
		Product prod2 = new Product("www.facebook.com", "social media network", 33);
		prod2.setDescription("network for people to post pictures");
		prod2.setPageSize(22);
		products.add(prod2);
		
		String response = jsonBuilderService.buildJSON(products);
		
		assertThat(response).contains("results");
		assertThat(response).contains("unit_price");
		assertThat(response).contains("size");
		assertThat(response).contains("title");
		assertThat(response).contains("description");
		assertThat(response).contains("total");
		assertThat(response).contains("\"total:\" 55.0");
	}
}