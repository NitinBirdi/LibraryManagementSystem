package com.lms.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lms.models.Book;
import com.lms.models.Constants;

public class LibraryStore {

	Map<String, Integer> actualBookQuantityByCategory;
	Map<String, Set<String>> booksIssuedToUserList;
	
	public LibraryStore() {
		booksIssuedToUserList = new HashMap<String, Set<String>>();
		actualBookQuantityByCategory = new HashMap<String, Integer>();
	}
	
	public void addBookInLibrary(Book book) {
		if (actualBookQuantityByCategory.containsKey(book.getName())) {
			actualBookQuantityByCategory.put(book.getName(), actualBookQuantityByCategory.get(book.getName()) + 1);
			return;
		}
		actualBookQuantityByCategory.put(book.getName(), 1);
	}
	
	public Map<String, Integer> getAvailableBooks() {
		return actualBookQuantityByCategory;
	}
	
	public Integer getNumberOfBooksIssuedToUser(String userName) {
		if (booksIssuedToUserList.containsKey(userName)) {
			return booksIssuedToUserList.get(userName).size();
		}
		return 0;
	}
	
	public Map<String, Set<String>> getBooksIssued() {
		return booksIssuedToUserList;
	}
	
	private void changeAvailableBookCounter(String name, Character oper) {
		Integer qty = actualBookQuantityByCategory.get(name);
		switch (oper) {
		case '-':
			qty -= 1;
			break;
		default:
			qty += 1;
		}
		actualBookQuantityByCategory.put(name, qty);
	}

	public void decrementAvailableBookCounter(String name) {
		changeAvailableBookCounter(name, Constants.PLUS);
	}

	public void incrementAvailableBookCounter(String name) {
		changeAvailableBookCounter(name, Constants.MINUS);
	}
	
	public void printIssuedList(String userName) {
		System.out.println("========= Books Issed to User ========= " + userName + " =============");
		Set<String> books = booksIssuedToUserList.get(userName);
		if (books == null || books.size() == 0) {
			System.out.println("No books have been issued");
			return;
		}
		for (String book : books) {
			System.out.println(book);
		}
	}
}
