package com.lms.main;

import com.lms.models.Book;
import com.lms.models.User;
import com.lms.services.LMSService;
import com.lms.services.LMSServiceFactory;

public class App {
	
	public static void main(String[] args) {
		LMSService lmsService = LMSServiceFactory.getInstance();
		
		Book book1 = new Book("Library", "Nitin");
		Book book2 = new Book("Building", "Clear");
		Book book3 = new Book("Life", "Denis");
		
		lmsService.addBook(book1);
		lmsService.addBook(book2);
		lmsService.addBook(book3);
	
		System.out.println("==================== Added Books: ===========================");
		lmsService.printBooks();
		System.out.println("\n");
		
		User user1 = new User("Ram");
		User user2 = new User("Ramesh");
		User user4 = new User("Rames");
		User user3 = new User("Shyam");
		
		lmsService.addUser(user1);
		lmsService.addUser(user2);
		lmsService.addUser(user3);
		lmsService.addUser(user4);
		
		System.out.println("\n==================== Added Users: ===========================");
		lmsService.printUsers();
		System.out.println("\n");
		
		System.out.println("\n==================== Lend Book: ===========================");
		lmsService.lendBook(user1, book2);
		lmsService.printIssuedList(user1.getUserName());
		System.out.println("\n");
		
		System.out.println("\n==================== Return Book: ===========================");
		lmsService.returnBook(user1, book2);
		lmsService.printIssuedList(user1.getUserName());
		System.out.println("\n");
		
		System.out.println("\n==================== Searching Books By Title: ===========================");
		lmsService.searchBookByTitle("Li");
		System.out.println("\n");
		
		System.out.println("\n==================== Searching Books By Title: ===========================");
		lmsService.searchBookByTitle("Library");
		System.out.println("\n");
		
		System.out.println("\n==================== Searching Books By Author: ===========================");
		lmsService.searchBookByAuthor("Nitin");
		System.out.println("\n");
		
		System.out.println("\n==================== Searching User: ===========================");
		lmsService.searchUser("Ra");
		System.out.println("\n");
	}
	
}
