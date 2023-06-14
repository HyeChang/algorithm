import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int resultNum = 0;
		int row = 0;
		int colume = 0;
		for( int i = 0; i < 9; i++ ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for( int j = 0; j < 9; j++ ) {
				
				int tempNum = Integer.parseInt(st.nextToken());
				if( tempNum > resultNum ) {
					resultNum = tempNum;
					row = i;
					colume = j;
				}
				
			}
			
		}
		sb.append(resultNum).append("\n").append(row+1).append(" ").append(colume+1);
		System.out.println(sb);
		
	}
	
}