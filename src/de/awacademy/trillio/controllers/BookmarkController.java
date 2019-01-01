package de.awacademy.trillio.controllers;

import de.awacademy.trillio.entities.Bookmark;
import de.awacademy.trillio.entities.User;
import de.awacademy.trillio.services.BookmarkService;

public class BookmarkController {

	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkService.getInstance().saveUserBookmark(user,bookmark);
	}
}
