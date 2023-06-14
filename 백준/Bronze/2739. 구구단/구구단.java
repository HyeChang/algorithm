import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] split = br.readLine().split(" ");
    	
    	int input = Integer.parseInt(split[0]);
    	
    	for(int i=1; i<=9; i++) {
    		System.out.println( input + " * " + i + " = " + (input*i) );
    	}
    }
}