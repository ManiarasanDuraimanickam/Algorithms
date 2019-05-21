package algo.tryout.string;

import org.junit.jupiter.api.Test;

public class TestStringSimilarity {

	private StringSimilarity similarity = new StringSimilarity();

	@Test
	public void testSimilarity() {
		String input = "abcabccba";
		long lenght = this.similarity.stringSimilarity(input);
		System.out.println("lenght-" +  lenght);
	}
}
