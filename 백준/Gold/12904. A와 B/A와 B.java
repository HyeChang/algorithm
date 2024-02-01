import java.io.IOException;

import java.util.*;

public class Main {
	
	static int CNT = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		String T = sc.next();
        
		System.out.println(Logic(S, T));
		
	} // main
	
	public static int Logic(String S, String T) {
		
		StringBuffer sbT = new StringBuffer(T);
		int cursor = (T.length() - 1);
		
		while(sbT.length() >= S.length()) {
			
			Character endChar = sbT.charAt(cursor);
			
			if(sbT.toString().equals(S)) {
				return 1;
			}
			
			// A로 끝날 때
			if(endChar == 'A') {
				sbT.deleteCharAt(cursor);
				cursor--;
			} else { // B로 끝날 때
				sbT.deleteCharAt(cursor);
				sbT.reverse();
				cursor--;
			}
			
		}
		
		return 0;
		
	}
	
} // Main