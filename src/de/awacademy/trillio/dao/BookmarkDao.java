package de.awacademy.trillio.dao;

import de.awacademy.trillio.DataStore;
import de.awacademy.trillio.entities.Bookmark;
import de.awacademy.trillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
