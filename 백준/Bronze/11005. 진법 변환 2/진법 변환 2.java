import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		int remainder = 0; // 나머지
		
		while(true) {
			
			remainder = N % B;
			N = N / B;
			
			if(remainder >= 10) {
				sb.append((char)(remainder + 'A' - 10));
			} else {
				sb.append(remainder);
			}
			
			if(N <= 0) {
				break;
			}
		}
		
		System.out.println(sb.reverse());
		
	}
	
}