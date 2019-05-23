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
		boolean byOwn = false;
		if (byOwn) {
			return checkstringSimilarityByOwn(s);
		} else {
			return checkstringSimilaritybyZalgo(s);
		}
	}

	public long checkstringSimilarityByOwn(String s) {
		byte[] src = s.getBytes();
		long matchChar = 0;
		for (int i = 1; i < src.length; i++) {
			/*if (src[0] != src[i]) {
				continue;
			}*/
			int j=i;
			while (j < src.length && src[j-i] == src[j++])
				matchChar++;
		}
		return matchChar + src.length;

	}

	public long checkstringSimilaritybyZalgo(String s) {
		char[] srcChar = s.toCharArray();
		long matchChar = srcChar.length;
		int totalLen = srcChar.length;
		int[] zarray = new int[totalLen];
		similaritybyZAlgorithm(srcChar, totalLen, zarray);
		for (int matchedchar : zarray) {
			matchChar += matchedchar;
		}
		// }
		return matchChar;

	}

	private void similaritybyZAlgorithm(char[] s, int n, int[] z) {
		int L = 0, R = 0;
		for (int i = 1; i < n; i++) {
			if (i > R) {
				L = R = i;
				while (R < n && s[R - L] == s[R])
					R++;
				z[i] = R - L;
				R--;
			} else {
				int k = i - L;
				if (z[k] < R - i + 1)
					z[i] = z[k];
				else {
					L = i;
					while (R < n && s[R - L] == s[R])
						R++;
					z[i] = R - L;
					R--;
				}
			}
		}
	}
}
