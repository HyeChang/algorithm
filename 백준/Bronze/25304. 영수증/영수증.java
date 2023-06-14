import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int resultA = 0;
    	int resultB = 0;
    	
    	int inputA = Integer.parseInt(br.readLine());
    	int inputB = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<inputB; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		resultA = (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken())); 
    		resultB += resultA;
    	}
    	if( resultB == inputA ) {
    		System.out.println("Yes");
    	} else {
    		System.out.println("No");
    	}
    }
}