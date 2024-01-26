import java.io.IOException;

import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[][] dp = new int[10001][4];
		int[] result = new int[T];
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i=0; i<T; i++) {
			
			
			int inputNum = sc.nextInt();
			
			for(int j=4; j<=inputNum; j++) {
				dp[j][1] = dp[j-1][1];
				dp[j][2] = dp[j-2][1] + dp[j-2][2];
				dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];
			}
			
			result[i] = dp[inputNum][1] + dp[inputNum][2] + dp[inputNum][3];
			
		}
		
		for(int r : result) {
			System.out.println(r);
		}
			
		
	} // main
		
} // Main