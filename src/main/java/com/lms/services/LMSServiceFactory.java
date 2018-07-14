package com.lms.services;

import com.lms.store.BookStore;
import com.lms.store.LibraryStore;
import com.lms.store.UserStore;
import com.lms.validators.Validator;

public class LMSServiceFactory {

	private static LMSService service = null;

	public static LMSService getInstance() {

		if (null == service) {

			Validator validator = new Validator();
			SearchService searchService = SearchServiceFactory.getInstance();
			service = new LMSService(validator, new UserStore(searchService), new BookStore(searchService),
					new LibraryStore());
		}
		
		return service;
	}
}
