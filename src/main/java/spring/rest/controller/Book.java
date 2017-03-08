package spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.model.Book;
import spring.rest.service.BookService;

@RestController
@RequestMapping(value = "books")
public class Book {

	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, List<Book>> getBooks() {
		Map<String, List<Book>> map = new HashMap<String, List<Book>>();
		map.put("books", this.bookService.getAllBook());
		return map;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Book> addBook(@RequestBody Book bookModel) {
		bookService.addBook(bookModel);
		return new ResponseEntity<Book>(bookModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> edit(@PathVariable("id") int id, @RequestBody Book bookModel) {
		System.out.println("Request user id is " + id);
		bookModel.setId(id);
		bookService.editBook(bookModel);
		ErrorCode.ERROR_VALIDATION.getCode();
		return new ResponseEntity<Book>(bookModel, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return "delete successfully";
	}

}
