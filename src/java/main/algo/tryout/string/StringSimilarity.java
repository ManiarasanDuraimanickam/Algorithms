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

	public long checkstringSimilarity(String s) {
		int matchChar = 0, strLen = s.length();
		String subStr = null;
		for (int i = 1; i < strLen; i++) {
			subStr = s.substring(i, strLen);
			//System.out.println("loop-"+i);
			if (s.charAt(0) != subStr.charAt(0)) {
				continue;
			}
			matchChar += getTotalMatchedChar(s, subStr);
		}
		return matchChar + strLen;

	}

	/*
	 * private int getTotalMatchedChar(String s, String substring) { int i = 0;
	 * while (s.charAt(i) == substring.charAt(i)) { i++; if (i >=
	 * substring.length()) { break; }
	 * 
	 * } return i; }
	 */

	private int getTotalMatchedChar(String s, String substring) {
		int i = 0, sstrlen = substring.length(), loop = sstrlen > 1 ? 1 : sstrlen, left = 0, right = 0;
		if (sstrlen < 2) {
			if (s.charAt(left) == substring.charAt(left)) {
				i++;
				if (loop < sstrlen && s.charAt(loop) == substring.charAt(loop)) {
					i++;
				}
			}
			return i;
		}
		while (loop < sstrlen) {
			left = loop - 1;
			right = loop + 1;
			if (s.charAt(left) == substring.charAt(left)) {
				i++;
				if (loop < sstrlen && s.charAt(loop) == substring.charAt(loop)) {
					i++;
					if (right < sstrlen && s.charAt(right) == substring.charAt(right)) {
						i++;
					} else {
						break;
					}
				} else {
					break;
				}
			} else {
				break;
			}
			loop= right+2;
		}
		return i;
	}
}
