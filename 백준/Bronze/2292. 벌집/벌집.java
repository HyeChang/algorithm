import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String N = br.readLine();
		int inputN = Integer.parseInt(N);
		int headNum = 2;
		int resultNum = 1;
		
		while( headNum <= inputN ) {
			
			headNum += 6 * resultNum;
			resultNum++;
			
		}
		System.out.println(resultNum);
		
	}
	
}