package spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.rest.dao.BookDao;
import spring.rest.model.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void addBook(Book book){
		this.bookDao.addBook(book);
	}
	
	public List<Book> getAllBook(){
		return this.bookDao.getAllBook();
	}
	
	public void deleteBook(int id){
		this.bookDao.deleteBook(id);
	}
	
	public void editBook(Book bookModel){
		this.bookDao.editBook(bookModel);
	}
	public Book findById(int id){
		return this.bookDao.findById(id);
	}
	
}
