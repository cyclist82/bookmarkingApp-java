package de.awacademy.trillio.entities;

import de.awacademy.trillio.services.BookmarkService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WebLinkTest {

	@Test
	void isKidFriendlyEligible() {
		// Testcase 1: porn in url -- false
		WebLink webLink = BookmarkService.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-asdasd-project-into-eclipse-and-get-up-and-running",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-porn-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);

		// Testcase 2: porn in title -- false
		webLink = BookmarkService.getInstance().createWebLink(2001,
				"How do I porn a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-sadasd-project-into-eclipse-and-get-up-and-running",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);
		// Testcase 3: adult in host -- false
		webLink = BookmarkService.getInstance().createWebLink(2001,
				"How do I asdcs a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-sadasd-project-into-eclipse-and-get-up-and-running",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflowadult.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible);

		// Testcase 4: adult in url, but not in host part -- true
		webLink = BookmarkService.getInstance().createWebLink(2001,
				"How do I asdsad a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-sadasd-project-into-eclipse-and-get-up-and-running",
				"http://stackoverflow.com/adult/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertTrue(isKidFriendlyEligible);

		// Testcase 5: adult in title only -- true
		webLink = BookmarkService.getInstance().createWebLink(2001,
				"How do I adult a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-sadasd-project-into-eclipse-and-get-up-and-running",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertTrue(isKidFriendlyEligible);

	}
}
