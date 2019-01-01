package de.awacademy.trillio.dao;

import de.awacademy.trillio.DataStore;
import de.awacademy.trillio.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
