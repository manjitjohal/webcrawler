package org.venturis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.venturis.domain.Product;
import org.venturis.service.JsonBuilderService;
import org.venturis.service.PageConsumerService;

/**
 * Main class for the application
 * 
 * @author Manjit Johal
 *
 */
@SpringBootApplication
public class PageConsumer implements CommandLineRunner {

	@Autowired
	private PageConsumerService pageConsumerService;

	@Autowired
	private JsonBuilderService jsonBuilderService;

	@Override
	public void run(String... args) {

		String urlString = "";

		if (args != null && args.length > 0) {
			urlString = args[0];
		}

		if (urlString.isEmpty()) {
			System.out.println("Please specify a valid url");
		} else {

			try {

				List<Product> products = pageConsumerService.generateProductData(urlString);

				if (products.size() > 0) {
					String json = jsonBuilderService.buildJSON(products);
					System.out.println("json has been generated below");
					System.out.println(json);
				} else {
					System.out
							.println("The page specified was invalid or no products were found");
				}

			} catch (IllegalStateException e) {
				System.out
						.println("Error: Please specify a valid chrome driver executable");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PageConsumer.class, args);
	}
}