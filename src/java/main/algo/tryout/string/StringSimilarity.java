package algo.tryout.string;

/**
 * You're comparing ababaa against all the possible substrings of that string.
 * So if you remove the first letter you get babaa and if you remove the first
 * and second letter you get abaa and so on.
 * 
 * When you compare these substrings, you want to see how many letters they have
 * in common, starting at the beginning of the original string. You have the
 * following 6 cases:
 * 
 * You're comparing the original string against itself. 6 out of 6 The original
 * string doesn't start with b, so you stop The original string starts with aba,
 * so 3 out of 4 match The original string doesn't stat with b, so you stop The
 * original string starts with a, so 1 out of 2 match The original string starts
 * with a, so 1 out of 1 match Here's a visual breakdown of the above cases:
 * 
 * 6: <b>ababaa<b> 0: babaa 3: <b>aba<b> a 0: baa 1: a a 1: a
 * 
 * @author maniarasand
 * 
 * 
 *
 */
public class StringSimilarity {
	public long checkstringSimilarity(String input) {
		char[] inputChars = input.toCharArray();
		int[] zarray = new int[inputChars.length];
		int left = 0, right = 0;
		long matchedChars = inputChars.length;
		for (int current = 1; current < inputChars.length; current++) {
			if (inputChars[0] != inputChars[current])
				continue;
			if (right > current) {

				if (zarray[current - left] < right - current + 1) {
					zarray[current] = zarray[current - left];
				}
				else {
					left=current;
					while(right<inputChars.length && inputChars[right-left]==inputChars[right])
						right++;
					zarray[current]=right-left;
					right--;
				}
				continue;
			}
			left = right = current;
			while (right < inputChars.length && inputChars[right - current] == inputChars[right])
				right++;
			zarray[current] = (right - current);
			right--;
		}
		for (int matched : zarray) {
			matchedChars += matched;
		}
		return matchedChars;

	}
}