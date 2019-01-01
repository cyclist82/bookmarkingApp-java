package de.awacademy.trillio.entities;

import de.awacademy.trillio.constants.BookGenre;
import de.awacademy.trillio.services.BookmarkService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BookTest {

	@Test
	void isKidFriendlyEligible() {
		// Test 1
		Book book = BookmarkService.getInstance().createBook(4000, "Walden", "-", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);

		// Test 2
		book = BookmarkService.getInstance().createBook(4000, "Walden", "-", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);
	}
}
