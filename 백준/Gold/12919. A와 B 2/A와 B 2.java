import java.io.IOException;

import java.util.*;

public class Main {
	
	static int CNT = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		String T = sc.next();
		
		System.out.println( (Logic(S, T) ? 1 : 0) );
		
	} // main
	
	public static boolean Logic(String S, String T) {
		
		StringBuffer sb = new StringBuffer(T);
		
		if(S.length() >= T.length()) {
			
			if(T.equals(S)) {
				return true;
			}
			
			return false;
			
		}
		
		// 문자열 뒤에 A 제거
		if(sb.charAt(sb.length() - 1) == 'A') {
			if( Logic(S, sb.substring(0, sb.length() - 1)) ) {
				return true;
			}
		}
		
		// 문자열 뒤집고 뒤에 B 제거
		if(sb.charAt(0) == 'B') {
			sb.reverse();
			if( Logic(S, sb.substring(0, sb.length() - 1)) ) {
				return true;
			}
		}
		return false;
	}
	
} // Main