package org.tutorial;

import java.util.List;

public interface BookService {

	/**
	 * find all books without any criteria
	 * 
	 * @return a list of Book objects
	 */
	List<Book> getAllBooks();

	/**
	 * find by whose title contains a string
	 * 
	 * @param searchText
	 *            the pattern to search
	 * @return a list of books whose title contains searchText
	 */
	List<Book> getBooksByTitle(String searchText);

}
