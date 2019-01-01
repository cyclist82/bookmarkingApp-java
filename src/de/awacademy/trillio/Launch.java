package de.awacademy.trillio;

import de.awacademy.trillio.entities.Bookmark;
import de.awacademy.trillio.entities.User;
import de.awacademy.trillio.services.BookmarkService;
import de.awacademy.trillio.services.UserService;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;


	private static void loadData() {
		System.out.println("1. Loading data...");
		DataStore.loadData();

		users = UserService.getInstance().getUsers();
		bookmarks = BookmarkService.getInstance().getBookmarks();

		System.out.println("Printing Data...");
		printUserData();
		printBookmarkData();

	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}

	private static void startBookmarking() {
		System.out.println("\r\n2. Bookmarking...");
		for (User user : users) {
			View.bookmark(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		startBookmarking();
	}
}
