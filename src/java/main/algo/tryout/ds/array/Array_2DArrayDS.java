package algo.tryout.ds.array;

public class Array_2DArrayDS {

	public long hourglassSum(int[][] arr) {
	int max=Integer.MIN_VALUE,total;
	
		for (short i = 0; i < arr.length - 2; i++) {
			for (short j = 0; j < arr.length - 2; j++) {
				total = arr[i][j]+ arr[i][j+1]+ arr[i][j+2];
				total+=arr[i+1][j+1];
				total+=arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				max=total>max?total:max;
			}
			
		}
		return max;
	}
}
