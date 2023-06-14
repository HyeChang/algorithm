import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
		int resultA;
		int tempA = -1000000;
		int tempB = 1000000;
		
		StringBuilder resultSB = new StringBuilder();
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		String inputA = br.readLine();
		StringTokenizer stA = new StringTokenizer(inputA);
		
		int inputN = Integer.parseInt(st.nextToken());
		for( int i=0; i<inputN; i++ ) {
			resultA = Integer.parseInt(stA.nextToken());
			if( tempA < resultA ) {
				tempA = resultA;
			}
			if( tempB > resultA ) {
				tempB = resultA;
			}
		}
		resultSB.append(tempB).append(" ").append(tempA);
		bw.write(String.valueOf(resultSB));
		
		br.close();
		bw.close();
	}
}