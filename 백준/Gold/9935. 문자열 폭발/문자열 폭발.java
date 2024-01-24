import java.io.IOException;

import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		
		String inputStr = sc.nextLine();
		String boomStr = sc.nextLine();
		int boomStrSize = boomStr.length();

		for(int i=0; i<inputStr.length(); i++) {
			
			boolean check = true;
			stack.push(inputStr.charAt(i));
			
			// boomStr크기가 입력스택보다 작거나 같을 때 비교 시작
			if(stack.size() >= boomStrSize) {
				
				for(int j=0; j<boomStrSize; j++) {
					
					// 입력 문자와 boomStr 비교 : (stackSize - boomStrSize) = 1씩 증가
					if(stack.get((stack.size() - boomStrSize) + j) != boomStr.charAt(j) ) {
						check = false;
						break;
					}
					
				} // for
				
				// boomStr과 입력 문자열이 같은게 존재 한다면 pop
				if(check) {
					for(int j=0; j<boomStrSize; j++) {
						stack.pop();
					}
				}
			}
			
		} // for
		
		StringBuilder sb = new StringBuilder();
		for(Character c : stack) {
			sb.append(c);
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
		
	} // main
	
}