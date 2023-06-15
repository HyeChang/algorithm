import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input =br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		int dayCnt = 0;

		// 구하는 날의 최소 날짜
		dayCnt = (V - B) / (A - B);

		// 목적지 까지 남은경우
		if( (V - B) % (A - B) != 0 ) {
			dayCnt++;
		}
		
		System.out.println(dayCnt);		

	}
	
}