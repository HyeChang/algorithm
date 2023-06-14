import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		String inputNum = br.readLine();
		int inputNumInt = Integer.parseInt(inputNum);
		if( inputNumInt < 0 && inputNumInt > 10 ) {
			System.out.println("ERROR :: input range : 1<= T <= 10");
			return;
		}
		
		for( int j=0; j<inputNumInt; j++ ) {
			
			String ch = br.readLine();
			int chLength = ch.length();
			if( chLength > 1000 ) {
				System.out.println("ERROR :: input range : 1000 ");
				return;
			}
			char headChar = 0;
			char tailChar = 0;
			// 문자열 확인
			for( int i=0; i<chLength; i++ ) {
				
				char chChar = ch.charAt(i);
				if( chChar >= 0x41 && chChar <= 0x5A ) {
				} else {
					System.out.println("ERROR :: Please enter only uppercase");
					return;
				}
				if( i == 0 ) {
					headChar = chChar;
				}
				if( i == chLength-1 ) {
					tailChar = chChar;
				}
			}
			
			System.out.print(headChar);
			System.out.println(tailChar);
			
		}
		br.close();
	}
}