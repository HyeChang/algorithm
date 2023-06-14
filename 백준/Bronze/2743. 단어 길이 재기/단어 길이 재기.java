import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String ch = sc.nextLine();
		
		int chLength = ch.length();
		// 문자열 확인
		for( int i=0; i<chLength; i++ ) {
			
			char chChar = ch.charAt(i);
			if( chChar >= 0x41 && chChar <= 0x5A || chChar >= 0x61 && chChar <= 0x7A ) {
			} else {
				System.out.println("영문 문자열만 입력하세요.");
				return;
			}
		}
		System.out.println(chLength);
        
	}
}