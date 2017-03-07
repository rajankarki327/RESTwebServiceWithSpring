package spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.rest.dao.BookDao;
import spring.rest.model.BookModel;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void addBook(BookModel book){
		this.bookDao.addBook(book);
	}
	
	public List<BookModel> getAllBook(){
		return this.bookDao.getAllBook();
	}
}
