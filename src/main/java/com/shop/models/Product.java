package com.shop.models;

public class Product extends ProductSuper{
	
	Integer id;
	String name;
	Double price;
//	String base64Image;
	
	Integer stockLeft;
	
	
	
	public Product(Integer id, String name, Double price,Integer stockLeft) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
//		this.base64Image = base64Image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStockLeft() {
		return stockLeft;
	}
	public void setStockLeft(Integer stockLeft) {
		this.stockLeft = stockLeft;
	}
	
//	public String getBase64Image() {
//        return base64Image;
//    }
	

}
