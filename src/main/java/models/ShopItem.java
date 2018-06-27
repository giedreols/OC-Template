package models;

import lombok.Data;

@Data
public class ShopItem {

	private String name;
	private String price;
	private String brand;
	private String productCode;
	private String amount;

	public ShopItem(String name, String price, String brand, String productCode) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.productCode = productCode;
	}

	public ShopItem(String name, String amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}