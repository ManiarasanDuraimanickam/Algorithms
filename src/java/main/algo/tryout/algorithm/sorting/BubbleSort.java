package algo.tryout.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int x = 3, y = 7,a=0,b=7;
		System.err.println(x + " " + y);
		x = x ^ y; 	// x-> 00000011
					// y-> 00000111
					// x-> 00000100
		System.err.println("stp - " + x + " " + y);
		y = x ^ y;	//	x-> 00000100
					//	y-> 00000111
					//	y-> 00000011(3)
		System.err.println("stp1 - " + x + " " + y);
		x = x ^ y;	//	x-> 00000100
					//	y-> 00000011(3)
					//	x-> 00000111(7)
		System.err.println("stp 2- "+x+" "+y);  
		a=a+b;
		b=a-b;
		a=a-b;
		System.err.println("stp 3- "+a+" "+b); 
		int[] arr = { 9, 11, 2, 5, 7, 8, 6, 3, 0, 1 };
		int[] actual = Arrays.copyOf(arr, arr.length);
//		bubbleSort(arr);
		insertionSort(arr);
//		selectionSort(arr);
//		mergeSort(arr);
		System.out.println("actual " + Arrays.toString(actual));
		System.out.println("sorted " + Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		int swap, len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - (1 + i); j++) {
				if (arr[j] > arr[j + 1]) {
					swap = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = swap;
				}
			}
		}
	}

	private static void insertionSort(int[] arr) {
		int cursorVal, j, swap;
		for (int i = 1; i < arr.length; i++) {
			cursorVal = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > cursorVal) {
				arr[j + 1] = arr[j];
				j--;

			}
			arr[j + 1] = cursorVal;

		}
	}

	static void insertionSort1(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	private static void selectionSort(int[] arr) {
		int minindex, swap;
		for (int i = 0; i < arr.length; i++) {
			minindex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minindex] > arr[j]) {
					minindex = j;
				}
			}
			swap = arr[i];
			arr[i] = arr[minindex];
			arr[minindex] = swap;

		}
	}

	private static void mergeSort(int[] arr) {

		divide(arr, 0, arr.length - 1);

	}

	private static void divide(int[] arr, int start, int end) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			divide(arr, start, mid);
			divide(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int sleft = mid - start + 1, sright = end - mid;
		int[] larr = new int[sleft];
		int[] rarr = new int[sright];

		for (int i = 0; i < sleft; i++)
			larr[i] = arr[i + start];
		for (int i = 0; i < sright; i++)
			rarr[i] = arr[i + mid + 1];

		System.out.println("larr " + Arrays.toString(larr));
		System.out.println("rarr " + Arrays.toString(rarr));

		int i = 0, j = 0, k = start;
		while (i < sleft && j < sright) {
			if (larr[i] <= rarr[j]) {
				arr[k] = larr[i];
				i++;
			} else {
				arr[k] = rarr[j];
				j++;
			}
			k++;
		}
		while (i < sleft) {
			arr[k] = larr[i];
			i++;
			k++;
		}
		while (i < sright) {
			arr[k] = rarr[j];
			j++;
			k++;
		}
		System.out.println("subarr " + Arrays.toString(arr));
	}
}
