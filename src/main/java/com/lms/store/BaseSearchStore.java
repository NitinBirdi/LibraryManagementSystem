package com.lms.store;

import java.util.ArrayList;

import com.lms.models.TrieNode;
import com.lms.services.SearchService;

abstract public class BaseSearchStore {

	protected SearchService searchService;
	
	public BaseSearchStore(SearchService searchService) {
		this.searchService = searchService;
	}
	
	protected void search(String name, TrieNode root) {
		ArrayList<String> result = (ArrayList<String>) searchService.search(root, name);
		if (result.size() == 0) {
			System.out.println("Sorry, nothing found!");
			return;
		}
		for (String str : result) {
			System.out.println(str);
		}
	}
}
