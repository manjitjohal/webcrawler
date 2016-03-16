package org.venturis.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;
import org.venturis.domain.Product;

/**
 * Service created to consume web page and generate product data
 * @author Manjit Johal
 *
 */
@Component
public class PageConsumerService {

	private static final String DRIVER_LOCATION = "C:/dev/misc/chromedriver.exe"; 
	
	public List<Product> generateProductData(String urlString) {

		
		System.setProperty("webdriver.chrome.driver",DRIVER_LOCATION);
		
		WebDriver driver = new ChromeDriver();
		driver.get(urlString);

		Document doc = Jsoup.parse(driver.getPageSource());

		Elements elements = doc.select("div.product");

		List<Product> products = new ArrayList<Product>();

		if(elements != null && elements.size() >0){

			for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext();) {
				products.add(getProductDetails(iterator.next()));
			}
		}
		driver.quit();
		return products;
	}

	/**
	 * Populates details and adds formatting clauses
	 * 
	 * @param element
	 * @return
	 */
	private Product getProductDetails(Element element) {

		Element firstLink = element.select("a").first();

		Product product = new Product();
		product.setUrl(firstLink.attr("href"));
		product.setTitle(firstLink.text());

		Element priceElement = element.select("p.pricePerUnit").first();
		String price = priceElement.text();
		price = price.replaceAll("[^\\d.]", "");
		product.setUnitPrice(Double.parseDouble(price));

		WebDriver subPageDriver = new ChromeDriver();
		subPageDriver.get(product.getUrl());

		Document subDoc = Jsoup.parse(subPageDriver.getPageSource());
		String description = subDoc.select("div.productText").first().text();
		product.setDescription(description);

		int bytes = subDoc.toString().getBytes().length;
		double pageSize = bytes / 1024.0;
		DecimalFormat twoDForm = new DecimalFormat("#.##");

		product.setPageSize(Double.valueOf(twoDForm.format((pageSize))));

		subPageDriver.quit();

		return product;
	}
}