import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int inputA = Integer.parseInt(br.readLine());
    	
    	for(int i=1; i<=inputA; i++) {
    		st = new StringTokenizer(br.readLine());
    		bw.write( "Case #" + i + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n" );
    	}
    	br.close();
    	bw.flush();
    	bw.close();
    }
}