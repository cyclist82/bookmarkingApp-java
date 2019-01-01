package de.awacademy.trillio;

import de.awacademy.trillio.constants.KidFriendlyStatus;
import de.awacademy.trillio.constants.UserType;
import de.awacademy.trillio.controllers.BookmarkController;
import de.awacademy.trillio.entities.Bookmark;
import de.awacademy.trillio.entities.User;
import de.awacademy.trillio.partner.Shareable;
import de.awacademy.trillio.services.BookmarkService;

public class View {


	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n\r" + user.getEmail() + " is browsing items ...");
		int bookmarkCount = 0;
		for (Bookmark[] bookmarks1 : bookmarks) {
			for (Bookmark bookmark : bookmarks1) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked --" + bookmark);
					}
				}
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.EDITOR)) {
					// Mark as kid-friendly
					if (bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkService.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
						}
					}
					// Sharing Bookmarks!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
				}
			}
		}
	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED :
				(Math.random() >= 0.5 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}
//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//		System.out.println("\n\r" + user.getEmail() + " is bookmarking");
//		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
//			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
//			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
//			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//			System.out.println(bookmark);

//		}
//	}
}
