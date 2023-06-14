import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputNum = br.readLine();
		int inputNumInt = Integer.parseInt(inputNum);
		if( inputNumInt < 0 && inputNumInt > 100 ) {
			System.out.println("ERROR :: input range : 1<= T <= 100");
			return;
		}
			
		String ch = br.readLine();
		int chLength = ch.length();
		if( chLength > inputNumInt ) {
			System.out.println("ERROR :: input range : " + inputNumInt);
			return;
		}
		int adder = 0;
		// 문자열 확인
		for( int i=0; i<chLength; i++ ) {
			
			char chChar = ch.charAt(i);
			if( chChar >= 0x30 && chChar <= 0x39 ) {
			} else {
				System.out.println("ERROR :: Please enter only number");
				return;
			}
			adder += Character.getNumericValue(chChar);
			
		}
		System.out.println(adder);
			
		br.close();
	}
}