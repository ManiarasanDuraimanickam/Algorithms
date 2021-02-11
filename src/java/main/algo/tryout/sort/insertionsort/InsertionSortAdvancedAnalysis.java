package algo.tryout.sort.insertionsort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortAdvancedAnalysis {

	public static long advancedAnalysisOfInsertionSort(int lenght, int[] array) {
		int temp;
		long rotation = 0;
		for (int i = 0; i < lenght - 1; i++) {
			if (array[i] > array[i + 1]) {
				rotation++;
				temp = array[i + 1];
				array[i + 1] = array[i];
				array[i] = temp;
				if (i > 0)
					rotation += rotateFurther(i, array);
			}
		}

		return rotation;
	}

	private static long rotateFurther(int end, int[] array) {
		int temp;
		long rotation = 0;
		for (int i = end; i > 0; i--) {
			if (array[i - 1] > array[i]) {
				rotation++;
				temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			} else {
				return rotation;
			}
		}
		return rotation;
	}

	static long insertionSort(int[] arr) {

		return advancedAnalysisOfInsertionSort(arr.length, arr);
	}

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		long result = insertionSort(new int[]{12,15,1,5,6,14,11,-2});
	}

	public static void main1(String[] args) throws IOException {
		StringWriter wrt = new StringWriter();
		BufferedWriter bufferedWriter = new BufferedWriter(wrt);

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			long result = insertionSort(arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
		System.out.println("wrt " + wrt.toString());
		scanner.close();
	}
}
