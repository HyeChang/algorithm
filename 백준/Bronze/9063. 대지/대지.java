import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> resultX = new ArrayList<>();
		ArrayList<Integer> resultY = new ArrayList<>();
		
		if(n <= 1) {
			
			String[] input = br.readLine().split(" ");
			
			System.out.println(0);
			
		} else {

			for(int i=0; i < n; i++) {
				
				String[] input = br.readLine().split(" ");
				
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);

				resultX.add(x);
				resultY.add(y);
				
			} // for
			
			int maxX = Collections.max(resultX);
			int minX = Collections.min(resultX);
			int maxY = Collections.max(resultY);
			int minY = Collections.min(resultY);
			
			System.out.println( (maxX - minX) * (maxY - minY) );
			
		} // else
		
		
	}
	
}