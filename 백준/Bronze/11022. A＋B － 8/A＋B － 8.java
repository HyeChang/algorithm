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
		
		for( int i=0; i<T; i++ ) {

			String[] inputNum = br.readLine().split(" ");
			int sum = 0;
			sum = Integer.parseInt(inputNum[0]) + Integer.parseInt(inputNum[1]);
			sb.append("Case #").append(i+1).append(": ").append(inputNum[0]).append(" + ").append(inputNum[1]).append(" = ")
			.append(sum).append("\n");
			
		}
		
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		System.out.println(sb);
			
	}
	
}