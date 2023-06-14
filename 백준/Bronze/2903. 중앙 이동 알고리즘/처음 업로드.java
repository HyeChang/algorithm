import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int result = 4;
		int doubleNum = 2;
		
		if( T > 0 ) {
			for( int i=1; i<=T; i++ ) {
				doubleNum *= 2;
				result = ((result * 4) - (doubleNum + 3));
			}
		}
		
		System.out.println(result);
			
	}
	
}
