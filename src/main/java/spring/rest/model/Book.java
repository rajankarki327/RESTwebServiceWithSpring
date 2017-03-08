package spring.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book {
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String auther_name;
	
	@Column
	private double book_price;

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

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}
	public Book(int id,String title,String a_name,int book_price){
		this.id=id;
		this.title=title;
		this.auther_name=a_name;
		this.book_price=book_price;
	}
	public Book(){}

	@Override
	public String toString() {
		return "BookModel [id=" + id + ", title=" + title + ", auther_name=" + auther_name + ", book_price="
				+ book_price + "]";
	}
	
	
}
