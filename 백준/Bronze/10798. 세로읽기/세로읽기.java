import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] inputStrArray = new String[5][15];
		
		// input
		for( int i = 0; i < 5; i++ ) {
			
			String[] inputStr = br.readLine().split("");
			int inputLen = inputStr.length;
			
			for( int j = 0; j < 15; j++ ) {

				if( inputLen > j ) {
					inputStrArray[i][j] = inputStr[j];
				} else {
					inputStrArray[i][j] = "";
				}
				
			}
			
		}
		
		// output
		for( int i = 0; i < 15; i++ ) {
			for( int j = 0; j < 5; j++ ) {
				
				System.out.print(inputStrArray[j][i]);
				
			}
		}
		
	}
	
}