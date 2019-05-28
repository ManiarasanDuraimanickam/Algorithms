package algo.tryout.ds.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestArray_2DArrayDS {

	private Array_2DArrayDS arrayDS = new Array_2DArrayDS();

	@Test
	public void hackertest1() {
		int[][] input = new int[6][6];
		input[0] = new int[] { 1, 1, 1, 0, 0, 0 };
		input[1] = new int[] { 0, 1, 0, 0, 0, 0 };
		input[2] = new int[] { 1, 1, 1, 0, 0, 0 };
		input[3] = new int[] { 0, 0, 2, 4, 4, 0 };
		input[4] = new int[] { 0, 0, 0, 2, 0, 0 };
		input[5] = new int[] { 0, 0, 1, 2, 4, 0 };
		int result = arrayDS.hourglassSum(input);
		assertEquals(19, result);

	}

	@Test
	public void hackertest2() {
		int[][] input = new int[6][6];
		input[0] = new int[] { 1, 1, 1, 0, 0, 0 };
		input[1] = new int[] { 0, 1, 0, 0, 0, 0 };
		input[2] = new int[] { 1, 1, 1, 0, 0, 0 };
		input[3] = new int[] { 0, 9, 2, -4, -4, 0 };
		input[4] = new int[] { 0, 0, 0, -2, 0, 0 };
		input[5] = new int[] { 0, 0, -1, -2, -4, 0 };
		int result = arrayDS.hourglassSum(input);
		assertEquals(13, result);

	}

	@Test
	public void hackertest3() {
		int[][] input = new int[6][6];
		input[0] = new int[] { -9, -9, -9, 1, 1, 1 };
		input[1] = new int[] { 0, -9, 0, 4, 3, 2 };
		input[2] = new int[] { -9, -9, -9, 1, 2, 3 };
		input[3] = new int[] { 0, 0, 8, 6, 6, 0 };
		input[4] = new int[] { 0, 0, 0, -2, 0, 0 };
		input[5] = new int[] { 0, 0, 1, 2, 4, 0 };
		int result = arrayDS.hourglassSum(input);
		assertEquals(28, result);

	}
}
