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
		StringBuilder resultSB = new StringBuilder();
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		String inputA = br.readLine();
		StringTokenizer stA = new StringTokenizer(inputA);
		
		int inputN = Integer.parseInt(st.nextToken());
		int inputX = Integer.parseInt(st.nextToken());
		for( int i=0; i<inputN; i++ ) {
			resultA = Integer.parseInt(stA.nextToken());
			if( inputX > resultA ) {
				resultSB.append(resultA).append(" ");
			}
		}
		String resultBW = resultSB.substring(0, resultSB.length() -1);
		bw.write(String.valueOf(resultBW));
		
		br.close();
		bw.close();
	}
}