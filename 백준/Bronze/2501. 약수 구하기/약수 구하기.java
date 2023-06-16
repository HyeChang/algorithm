import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		int firstNum = Integer.parseInt(st.nextToken());
		int secondNum = Integer.parseInt(st.nextToken());
		int tempCmt = 0;
		int result = 0;

		for( int i=1; i<=(firstNum+1); i++ ) {
			// 약수 확인
			if( (firstNum % i) == 0 ) {
				tempCmt++;
				result = i;
				if( tempCmt == secondNum ) {
					break;
				}
			}

			if( tempCmt > secondNum ) {
				result = 0;
				break;
			}
			
		}

		if( tempCmt == 0 || tempCmt < secondNum ) {
			result = 0;
		}

		System.out.println(result);

	}
	
}