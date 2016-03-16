package org.venturis.service;

import java.util.Iterator;
import java.util.List;

import org.jglue.fluentjson.JsonBuilderFactory;
import org.springframework.stereotype.Component;
import org.venturis.domain.Product;

import com.google.gson.JsonObject;

/**
 * Class used to build up json for product list
 * 
 * @author Manjit Johal
 *
 */
@Component
public class JsonBuilderService {

	/**
	 * Builds up json according to requirements gets a running total of the
	 * values
	 */
	public String buildJSON(List<Product> products) {

		if (products != null && products.size() > 0) {
			org.jglue.fluentjson.JsonArrayBuilder<?, JsonObject> jsonArrayBuilder = JsonBuilderFactory
					.buildObject().addArray("results");

			double total = 0.0;

			for (Iterator<Product> iterator = products.iterator(); iterator
					.hasNext();) {

				Product product = iterator.next();

				jsonArrayBuilder.addObject().add("title", product.getTitle())
						.add("size", product.getPageSize() + "kb")
						.add("unit_price", product.getUnitPrice())
						.add("description", product.getDescription());

				total += product.getUnitPrice();

			}

			String totalString = "],\"total:\" " + total;

			String composedString = jsonArrayBuilder.end().toString();

			String newString = composedString.replace("]", totalString);
			return newString;
		} else
			return "";
	}
}