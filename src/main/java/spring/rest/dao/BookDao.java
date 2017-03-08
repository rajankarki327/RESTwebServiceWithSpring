package spring.rest.dao;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.rest.model.Book;

@Transactional
public class BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addBook(Book bookModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bookModel);
	}
	
	public List<Book> getAllBook(){
		Session session =this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) session.createQuery("from BookModel").list();
		return books;
	}
	public void deleteBook(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		session.delete(book);
	}
	
	public void editBook(Book bookModel){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bookModel);
	}
	
	public Book findById(int id){
		Session session =this.sessionFactory.getCurrentSession();
		Book book = (Book) session.createQuery("from BookModel where id=:id").setParameter("id", id);
		return book;
	}
	

}
