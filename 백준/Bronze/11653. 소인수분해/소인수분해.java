import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
			
		boolean flag = true;
		int quotient = 0;
			
		while(flag) {
			
			boolean primeFlag = false;
			
			// 소수 구하기
			for(int i = 2; i <= Math.sqrt(N); i++) {
				
				// 소수 일때
				if(N % i == 0) {
					
					quotient = N / i;
					N = quotient;
					primeFlag = true;
					System.out.println(i);
					break;
					
				}
				
			} // for
			
			if(N == 1) {
				flag = false;
			} else if(primeFlag == false) {
				flag = false;
				System.out.println(N);
			}
			
		} // while
		
	}
	
}