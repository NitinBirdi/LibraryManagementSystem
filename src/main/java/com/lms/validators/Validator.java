package com.lms.validators;

import java.util.Map;
import java.util.Set;

import com.lms.models.Constants;
import com.lms.models.Result;
import com.lms.models.ValidationMessages;

public class Validator {

	public Result validateUserIssueRequest(Set<String> uniqueBooksIssued, String bookName) {
		StringBuilder sb = new StringBuilder();

		if (Constants.MAX_BOOKS_ALLOWED <= uniqueBooksIssued.size()) {
			sb.append(ValidationMessages.MAX_ISSUE_LIMIT);
		}
		if (uniqueBooksIssued.contains(bookName)) {
			sb.append(ValidationMessages.BOOK_ALREADY_ISSUED);
		}

		return new Result(sb.toString());
	}

	public Result validateBookAvailability(Map<String, Integer> actualBookQuantityByCategory, String bookName) {
		String str = null;
		if (!actualBookQuantityByCategory.containsKey(bookName) || actualBookQuantityByCategory.get(bookName) == 0) {
			str = ValidationMessages.BOOK_NOT_AVAILABLE;
		}
		return new Result(str);
	}
}
