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
		int cnt = 0;
 
		int input = Integer.parseInt(br.readLine());
		String inputV = br.readLine();
		StringTokenizer st = new StringTokenizer(inputV);
		String str, out = "";
		
		String resultInt = br.readLine();
		
		for( int i=0; i<input; i++ ) {
			str = st.nextToken();
			if( resultInt.equals(str) ) {
				cnt++;
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		br.close();
		bw.flush();
		bw.close();
	}
}