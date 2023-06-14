import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int add = 0;
    	
    	int input = Integer.parseInt(br.readLine());
    	
    	for(int i=1; i<=input; i++) {

    		add = add + i;
    		
    	}
    	System.out.println(add);
    }
}