import java.io.IOException;

import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 동전 종류
        int k = sc.nextInt(); // 목표 금액
        int[] coin = new int[n];
        
        int[] dp = new int[100001];
        
        for(int i=0; i<n; i++) {
        	coin[i] = sc.nextInt();
        }
        
        dp[0] = 1; // 자기 자신일 때 1개 소유
        // dp[현대 동전의 경우의 수] = dp[현재 동전의 경우의 수] + dp[(n번째 경우의 수) - (현재 동전)]
        for(int i=0; i<n; i++) { // 동전
        	// 목표 금액 만큼 
        	for(int j=coin[i]; j<=k; j++) {
        		dp[j] = dp[j] + dp[j - coin[i]];
        	}
        }

        System.out.println(dp[k]);
        
	} // main
		
} // Main