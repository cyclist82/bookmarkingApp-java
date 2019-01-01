package de.awacademy.trillio.entities;

import de.awacademy.trillio.constants.MovieGenre;
import de.awacademy.trillio.services.BookmarkService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class MovieTest {

	@Test
	void isKidFriendlyEligible() {
		// Test 1
		Movie movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "-", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.HORROR, 8.5);
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);

		// Test 2
		movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "-", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.THRILLERS, 8.5);
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);

	}
}
