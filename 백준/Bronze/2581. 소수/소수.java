import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int add = 0;
		int minNum = -1;
		
		for(int i = M; i <= N; i++) {
			
			boolean flag = true;
			
			// 소수 구하기
			for(int j = 2; j <= Math.sqrt(i); j++) {
				
				// 소수 아닌 경우
				if(i % j == 0) {
					flag = false;
					break;
				}
				
			}
			
			// 소수일 경우
			if(flag == true && minNum == -1 && i > 1) { 
				add += i;
				minNum = i;
			} else if(flag == true && i > 1) {
				add += i;
			}
			
		}
		
		if(minNum == -1) {
			System.out.println(minNum);
		} else {
			System.out.println(add);
			System.out.println(minNum);
		}
		
	}
	
}