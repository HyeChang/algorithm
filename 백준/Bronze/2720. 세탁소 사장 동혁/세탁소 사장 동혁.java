import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		double[] moneyArray = {0.25, 0.10, 0.05, 0.01};
		int[] moneyResult = {0, 0, 0, 0};
		
		for( int i=0; i<T; i++ ) {
            
			int C = Integer.parseInt(br.readLine());
			double CtoD = C * 0.01;
			
			for( int j=0; j<4; j++ ) {
				
				moneyResult[j] = (int)(CtoD / moneyArray[j]);
				if( moneyResult[j] <= 0 ) {
					moneyResult[j] = 0;
					sb.append(moneyResult[j]).append(" ");
					continue;
				}
				CtoD = Math.round( ((CtoD - (moneyArray[j] * moneyResult[j])) * 100.0) ) / 100.0;
				sb.append(moneyResult[j]).append(" ");
				
			}
			
			sb.deleteCharAt(sb.lastIndexOf(" "));
			sb.append("\n");
			
		}
		
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		System.out.println(sb);
			
	}
	
}