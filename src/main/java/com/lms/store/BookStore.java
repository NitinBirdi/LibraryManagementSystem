package com.lms.store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lms.models.Book;
import com.lms.models.TrieNode;
import com.lms.services.SearchService;

public class BookStore extends BaseSearchStore {

	private Set<Book> setBooks;
	private Map<String, String> bookByAuthor;
	private TrieNode bookRoot = null;
	
	public BookStore(SearchService searchService) {
		super(searchService);
		setBooks = new HashSet<Book>();
		bookByAuthor = new HashMap<String, String>();
		bookRoot = new TrieNode((char) 0);
	}
	
	public void addBook(Book book) {
		bookByAuthor.put(book.getAuthor(), book.getName());
		setBooks.add(book);
		bookByAuthor.put(book.getAuthor(), book.getName());
		searchService.insert(bookRoot, book.getName());
	}
	
	public void searchBookByAuthor(String authorName) {
		if (bookByAuthor.containsKey(authorName)) {
			System.out.println(bookByAuthor.get(authorName));
		}
	}
	
	public void searchBookByTitle(String bookName) {
		search(bookName, bookRoot);
		
	}
	
	public void printBooks() {
		if (setBooks.size() == 0) {
			System.out.println("No books have been added");
			return;
		}
		for (Book book : setBooks) {
			System.out.println(book.getName());
		}
	}
}
