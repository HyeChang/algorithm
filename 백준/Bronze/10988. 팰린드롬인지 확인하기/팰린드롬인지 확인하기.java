import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputStr = br.readLine();
		
		int inputLength = inputStr.length();
		
		if( inputLength < 1 && inputLength > 100 ) {
			System.out.println("input values (1 <= X <= 100)");
			return;
		}
		
		for( int i=0; i<inputLength; i++ ) {
			
			char tempChar = inputStr.charAt(i);
			char tempCharTail = inputStr.charAt((inputLength-1) - i);
			if( tempChar < 0x61 && tempChar > 0x7A ) {
				System.out.println("소문자만 입력하세요.");
				return;
			}
			
			if( tempChar != tempCharTail ) {
				System.out.println("0");
				return;
			}
			
		}
		
		System.out.println("1");
		
		br.close();
	}
}