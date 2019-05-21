package algo.tryout.search.string;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringSearch {

	private final Logger logger = Logger.getLogger("StringSearch");

	public List<Matched> findMatch(String originalText, String searchText) {
		List<Matched> matchedLists = new ArrayList<>();
		logger.info("started");
		long startTime = System.currentTimeMillis();
		if (null == originalText || null == searchText || originalText.length() < 1 || searchText.length() < 1) {
			logger.log(Level.SEVERE, "Null values cannot be processed.");
			return null;
		}
		int searchTextLenght = searchText.length();
		int originalTextLenght = originalText.length();
		if (searchTextLenght > originalTextLenght) {
			logger.log(Level.SEVERE, "Search Text should be less than original Text.");
			return null;
		}
		Matched matchedObj;
		String originalPartText;
		int noofposibilities = originalTextLenght - searchTextLenght;
		/**
		 * search.findMatch("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags", "ar"); Ma, an , ni, ia, ar, ra, as, sa,
		 * an, na, ar, rs, sa, ar, rs,
		 */
		for (int i = 0; i <= noofposibilities; i++) {
			originalPartText = originalText.substring(i, Math.min(searchTextLenght, originalTextLenght));
			if (getMatched(originalPartText, searchText)) {
				matchedObj = new Matched();
				matchedObj.setPhase(originalPartText);
				matchedObj.setStartIndex(i+1);
				matchedObj.setEndIndex(searchTextLenght);
				matchedLists.add(matchedObj);
			}
			searchTextLenght++;

		}
		logger.info("completed");
		long endTime = System.currentTimeMillis();
		logger.info("processed Time- " + (endTime - startTime) / 1000);
		return matchedLists;
	}

	public boolean getMatched(String original, String search) {
		return original.equalsIgnoreCase(search);
	}
}
