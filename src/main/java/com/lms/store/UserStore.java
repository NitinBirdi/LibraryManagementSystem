package com.lms.store;

import java.util.HashSet;
import java.util.Set;

import com.lms.models.TrieNode;
import com.lms.models.User;
import com.lms.services.SearchService;

public class UserStore extends BaseSearchStore {

	Set<User> setUsers;
	private TrieNode userRoot = null;

	public UserStore(SearchService searchService) {
		super(searchService);
		setUsers = new HashSet<User>();
		userRoot = new TrieNode((char) 0);
	}

	public void addUser(User user) {
		if (setUsers.contains(user)) {
			return;
		}
		setUsers.add(user);
		searchService.insert(userRoot, user.getUserName());
	}

	public void printUsers() {
		if (setUsers.size() == 0) {
			System.out.println("No Users have been added");
			return;
		}
		for (User user : setUsers) {
			System.out.println(user.getUserName());
		}
	}

	public void searchUser(String userName) {
		search(userName, userRoot);
	}
}
