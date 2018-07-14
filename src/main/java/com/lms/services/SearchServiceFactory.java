package com.lms.services;

public class SearchServiceFactory {

	private static SearchService service = null;

	public static SearchService getInstance() {

		if (null == service) {
			service = new SearchService();
		}
		return service;
	}
}
