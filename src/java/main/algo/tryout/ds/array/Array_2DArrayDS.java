package algo.tryout.ds.array;

public class Array_2DArrayDS {

	public int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE, total;

		for (short i = 0; i < arr.length - 2; i++) {
			for (short j = 0; j < arr.length - 2; j++) {
				total = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
				total += arr[i + 1][j + 1];
				total += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				max = total > max ? total : max;
			}

		}
		return max;
	}

	public int hourglassSumByJava8(int[][] arr) {

		return 0;
	}

	public static void main(String args[]) {
		int a[][] = { { 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

		int sum = 0;
		int counti = 0;
		int totalCount = 0;
		int rowCount = 0;
		// for(int rowNum=0;rowNum<4;rowNum++) {
		for (int i = 0; i < 6; i++) {

			int countj = 0;

			if (counti == 3) {
				counti = 0;
				break;
			}
			for (int j = 0; j < 6; j++) {
				// System.out.println(totalCount);
				if (totalCount == 3 || totalCount == 5) {
					totalCount++;
					break;
				} else {
					if (countj == 3) {
						countj = 0;
						totalCount++;
						break;
					}
					if (countj < 3) {
						sum = sum + a[i][j];
						rowCount = rowCount + 1;
					}
				}
				countj++;
				totalCount++;

			}
			System.out.print(rowCount + " ");
			// System.out.println();
			counti++;

		}

		// }
	}
}
