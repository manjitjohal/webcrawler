package org.venturis.domain;

/**
 * Used to encapsulate the product details that are retrieved
 * @author Manjit Johal
 *
 */
public class Product {
	
	
	private String url;
	private String title;
	private double unitPrice;
	private String description;
	private double pageSize;
	
	public Product(){}
	
	public Product(String url, String title, double unitPrice) {
		super();
		this.title = title;
		this.unitPrice = unitPrice;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Product [url=" + url + ", title=" + title + ", unitPrice="
				+ unitPrice + ", description=" + description + ", pageSize="
				+ pageSize + "]";
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPageSize() {
		return pageSize;
	}

	public void setPageSize(double pageSize) {
		this.pageSize = pageSize;
	}
}
