import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inputN = Integer.parseInt(br.readLine());
		int decimalCnt = 0;
		
		String[] inputStr = br.readLine().split(" ");
		
		for(int i=0; i<inputN; i++) {
			
			int inputNum = Integer.parseInt(inputStr[i]);
			boolean decimalFlg = true;
			
			// 소수 판단
			for(int j=2; j<inputNum; j++) {
				
				if( (inputNum % j) == 0 ) {
					decimalFlg = false;
					break;
				}
				
			}// for_2
			
			if( decimalFlg == true && inputNum > 1 ) {
				decimalCnt++;
			}
			
		}// for_1
		
		System.out.println(decimalCnt);
		
	}
	
}