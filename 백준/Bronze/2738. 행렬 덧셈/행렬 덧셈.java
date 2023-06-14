import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] resultMatrix = new int[n][m];
		
		// 입력
		for( int i = 0; i < n * 2; i++ ) {
			
			st = new StringTokenizer(br.readLine());
			
			for( int j = 0; j < m; j++ ) {
				
				resultMatrix[i % n][j] += Integer.parseInt(st.nextToken());
				if( i >= n ) {
					sb.append(resultMatrix[i % n][j]).append(" ");
				}
				
			}
		}
		
		System.out.println(sb);
		
	}
	
}