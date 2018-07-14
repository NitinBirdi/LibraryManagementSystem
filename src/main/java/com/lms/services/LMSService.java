package com.lms.services;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lms.models.Book;
import com.lms.models.Result;
import com.lms.models.ResultStatus;
import com.lms.models.User;
import com.lms.store.BookStore;
import com.lms.store.LibraryStore;
import com.lms.store.UserStore;
import com.lms.validators.Validator;

public class LMSService {

	Validator validator;

	private UserStore userStore;
	private BookStore bookStore;
	private LibraryStore libraryStore;
	
	public LMSService(Validator validator, UserStore userStore, BookStore bookStore, LibraryStore libraryStore) {
		this.validator = validator;
		this.bookStore = bookStore;
		this.userStore = userStore;
		this.libraryStore = libraryStore;
	}

	public void printBooks() {
		bookStore.printBooks();
	}

	public void printUsers() {
		userStore.printUsers();
	}

	public void printIssuedList(String userName) {
		libraryStore.printIssuedList(userName);
	}

	public void addBook(Book book) {
		libraryStore.addBookInLibrary(book);
		bookStore.addBook(book);
	}

	public void addUser(User user) {
		userStore.addUser(user);
	}

	public void lendBook(User user, Book book) {

		Map<String, Integer> actualBookQuantityByCategory = libraryStore.getAvailableBooks();
		Result result = validator.validateBookAvailability(actualBookQuantityByCategory, book.getName());

		if (result.getStatus() == ResultStatus.FAILURE) {
			System.out.println(result.getMessage());
			return;
		}

		String userName = user.getUserName();
		Set<String> uniqueBooksIssued;

		Map<String, Set<String>> booksIssuedToUserList = libraryStore.getBooksIssued();
		
		if (booksIssuedToUserList.containsKey(userName)) {
			uniqueBooksIssued = booksIssuedToUserList.get(userName);

			result = validator.validateUserIssueRequest(uniqueBooksIssued, book.getName());

			if (result.getStatus() == ResultStatus.FAILURE) {
				System.out.println(result.getMessage());
				return;
			}

		} else {
			uniqueBooksIssued = new HashSet<String>();
		}
		uniqueBooksIssued.add(book.getName());
		booksIssuedToUserList.put(userName, uniqueBooksIssued);

		libraryStore.decrementAvailableBookCounter(book.getName());
	}

	public void returnBook(User user, Book book) {
		Map<String, Set<String>> booksIssuedToUserList = libraryStore.getBooksIssued();
		Set<String> uniqueBooksIssued = booksIssuedToUserList.get(user.getUserName());
		
		Boolean isValidBookReturn = uniqueBooksIssued.remove(book.getName());
		
		if (uniqueBooksIssued.isEmpty()) {
			//this user has now no issued books
			booksIssuedToUserList.remove(user.getUserName());
		}
		
		if (isValidBookReturn) {
			booksIssuedToUserList.put(user.getUserName(), uniqueBooksIssued);
			libraryStore.incrementAvailableBookCounter(book.getName());
		}
	}

	public void searchBookByTitle(String bookName) {
		System.out.println("On Searching for bookName (prefix) " + bookName + " found: ");
		bookStore.searchBookByTitle(bookName);
	}

	public void searchBookByAuthor(String authorName) {
		bookStore.searchBookByAuthor(authorName);
	}

	public void searchUser(String userName) {
		System.out.println("On Searching for username " + userName + " found: ");
		userStore.searchUser(userName);
	}
}
