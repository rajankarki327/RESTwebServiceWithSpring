package spring.rest.dao;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.rest.model.BookModel;

@Transactional
public class BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addBook(BookModel bookModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bookModel);
	}
	
	public List<BookModel> getAllBook(){
		Session session =this.sessionFactory.getCurrentSession();
		List<BookModel> books = (List<BookModel>) session.createQuery("from BookModel").list();
		return books;
	}
	public void deleteBook(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		BookModel book = (BookModel) session.load(BookModel.class, new Integer(id));
		session.delete(book);
	}
	
	public void editBook(BookModel bookModel){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bookModel);
	}
	
	public BookModel findById(int id){
		Session session =this.sessionFactory.getCurrentSession();
		BookModel book = (BookModel) session.createQuery("from BookModel where id=:id").setParameter("id", id);
		return book;
	}
	

}
