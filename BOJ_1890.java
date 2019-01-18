package Algorithm;

import java.util.Scanner;

public class BOJ_1890 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arr = new int[101][101];
		long[][] cnt = new long[101][101];
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		cnt[0][0]=1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if(i == n-1 && j == n-1)
					continue;
				
				temp = arr[i][j];
				
				if (temp != 0) {
					if (i + temp < n)
						cnt[i + temp][j]+=cnt[i][j];

					if (j + temp < n)
						cnt[i][j + temp]+=cnt[i][j];
				}
				
			}
		}
		System.out.println(cnt[n - 1][n - 1]);

	}
}
