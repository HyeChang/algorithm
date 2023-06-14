import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int add = 0;
    	
    	int inputA = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<inputA; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
}