package algo.tryout.search.string;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestStringSearch {
	StringSearch search = new StringSearch();

	@Test
	public void testWord() {

		List<Matched> result = search.findMatch("Maniarasanarsars", "ar");
		assertNotNull(result);
		result.forEach(System.out::println);
	}

	@Test
	public void testWord1() {
		List<Matched> result = search.findMatch(
				"Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags",
				"ar");
		assertNotNull(result);
		result.forEach(System.out::println);
	}

	@Test
	public void testWord2() {
		StringBuilder builder = new StringBuilder();
		builder.append(
				"Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags")
				.append("Maniarasanarsarsasbdvdvasvdasvchgaejasbdjhasarhasbdharajhabhasbhrahdasbhasbvfchgasvgargashgvasgdvgasvagsvrahhharvagsvagsvdgasvdascraaaraarararararararavsgvagsvdags");
		List<Matched> result = search.findMatch(builder.toString(), "ar");
		assertNotNull(result);
		result.forEach(System.out::println);
	}

}
