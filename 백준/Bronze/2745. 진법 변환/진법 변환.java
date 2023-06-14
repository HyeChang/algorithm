import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		String N = input[0];
		int B = Integer.parseInt(input[1]);
		
		int pow = 0;
		
		char[] charArry = N.toCharArray();
		
		for( int i=0; i<charArry.length; i++ ) {
			
			char ch = charArry[i];
			
			if( ch >= 'A' ) {
				pow = pow * B + (ch - 'A' + 10);
			} else {
				pow = pow * B + (ch - '0');
			}
			
		}
		
		System.out.println(pow);
		
	}
	
}