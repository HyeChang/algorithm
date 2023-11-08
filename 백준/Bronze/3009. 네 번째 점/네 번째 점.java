import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] inputX = new int[3];
		int[] inputY = new int[3];
		
		// 3개 점 입력
		for(int i = 0; i < 3; i++) {
			
			String[] A = br.readLine().split(" ");
			
			inputX[i] = Integer.parseInt(A[0]);
			inputY[i] = Integer.parseInt(A[1]);
			
		}
		
		System.out.println(xyCompare(inputX) + " " + xyCompare(inputY));
		
	}
	
	// 값 비교 확인 함수
	static int xyCompare(int[] a) {
		
		int temp = a[0];
		int cnt = 0;
		int result = 0;
		
		for(int i=1; i < a.length; i++) {

			if(temp != a[i]) {
				result = a[i];
				cnt++;
			} 
			
		}
		
		if(cnt == 1) {
			return result;
		} else {
			return temp;
		}
	}
	
	
}