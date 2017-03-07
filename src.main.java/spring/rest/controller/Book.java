package spring.rest.controller;

public class Book {
	int id;
	String title;
	String auther_name;
	int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther_name() {
		return auther_name;
	}
	public void setAuther_name(String auther_name) {
		this.auther_name = auther_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Book(int id,String title,String auther_name,int price){
		this.id=id;
		this.auther_name=auther_name;
		this.title=title;
		this.price=price;
	}
	public Book(){}

}
