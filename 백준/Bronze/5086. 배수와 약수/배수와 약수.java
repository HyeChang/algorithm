import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {

			// 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int firstNum = Integer.parseInt(st.nextToken());
			int secondNum = Integer.parseInt(st.nextToken());

			// 입력 중지
			if( firstNum == 0 && secondNum == 0 ) {
				break;
			}

			if( (secondNum % firstNum) == 0 ){ // 첫번째 숫자가 약수 라면
				sb.append("factor").append("\n");
			} else if( (firstNum % secondNum) == 0 ) { // 배수 
				sb.append("multiple").append("\n");
			} else {
				sb.append("neither").append("\n");
			}


		}

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb);

	}
	
}