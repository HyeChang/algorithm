import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] A = br.readLine().split(" ");
		
		int x = Integer.parseInt(A[0]);
		int y = Integer.parseInt(A[1]);
		int w = Integer.parseInt(A[2]);
		int h = Integer.parseInt(A[3]);
		
		int resultWX = w - x;
		int resultHY = h - y;
		
		int resultX = 0;
		int resultY = 0;

		if(x >= resultWX) resultX = resultWX;
		if(x <= resultWX) resultX = x;
		if(y >= resultHY) resultY = resultHY;
		if(y <= resultHY) resultY = y;
		
		System.out.println( ((resultX >= resultY) ? resultY : resultX) );
		
	}
	
}