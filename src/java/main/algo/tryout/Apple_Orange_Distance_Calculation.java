package algo.tryout;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Apple_Orange_Distance_Calculation {

	// Complete the countApplesAndOranges function below.
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		 long totalApples =Arrays.stream(apples).map(n -> n +a).filter(n -> (n >=s && n<=t)==true).boxed().collect(Collectors.counting());
		 long totalOrange =Arrays.stream(oranges).map(n -> n +b).filter(n -> (n >=s && n<=t)==true).boxed().collect(Collectors.counting());
		System.out.println(totalApples);
		System.out.println(totalOrange);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] st = scanner.nextLine().split(" ");

		int s = Integer.parseInt(st[0]);

		int t = Integer.parseInt(st[1]);

		String[] ab = scanner.nextLine().split(" ");

		int a = Integer.parseInt(ab[0]);

		int b = Integer.parseInt(ab[1]);

		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		int[] apples = new int[m];

		String[] applesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int applesItem = Integer.parseInt(applesItems[i]);
			apples[i] = applesItem;
		}

		int[] oranges = new int[n];

		String[] orangesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int orangesItem = Integer.parseInt(orangesItems[i]);
			oranges[i] = orangesItem;
		}

		countApplesAndOranges(s, t, a, b, apples, oranges);

		scanner.close();
	}
}

/**
 * 7 11 5 15 3 2 -2 2 1 5 -6
 */
