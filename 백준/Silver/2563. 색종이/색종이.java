import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String inputNumStr = br.readLine();
		int inputNum = Integer.parseInt(inputNumStr);
		int[][] inputArray = new int[100][100];
		int redupCnt = 0;
		
		// input
		for( int i=0; i<inputNum; i++ ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for( int j=x; j<x + 10; j++ ) {
				for( int p=y; p<y + 10; p++ ) {
					
					inputArray[j][p] += 1;
					
				}
			}
			
		}// for_input
		
		// 판단
		int tempInt = 0;
		for( int i=0; i<100; i++ ) {
			for( int j=0; j<100; j++ ) {
				
				tempInt = inputArray[i][j];
				
				if( tempInt >= 2 ) {
					redupCnt += tempInt - 1;
				}
				
			}
		}// for_판단
		
		// output
		int result = (inputNum * 100) - redupCnt;
		System.out.println(result);
		
	}
	
}