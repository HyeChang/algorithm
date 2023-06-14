import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		int inputN = Integer.parseInt(N);
		
		boolean flag = false;
		int x = (inputN - 1) > 0 ? 2 : 0;
		int y = (inputN - 1) > 0 ? -1 : 0;;
		
		for( int i=0; i<(inputN-1); i++ ) {
			if( flag == false ) { // y = 0
				
				x--;
				y++;
				
				if( x <= 0 && (inputN-2) != i ) {
					flag = true;
					x -= 1;
					y += 2;
				}
			} else { // x = 0
				x++;
				y--;
				
				if( y <= 0 && (inputN-2) != i ) {
					flag = false;
					x += 2;
					y -= 1;
				}
			}
			
		} // for
		
		sb.append(y+1).append("/").append(x+1);
		System.out.println(sb);
        
	}
	
}