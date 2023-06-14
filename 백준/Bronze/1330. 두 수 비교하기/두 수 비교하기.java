import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	String[] spilt = br.readLine().split(" ");
    	int a = Integer.parseInt(spilt[0]); 
    	int b = Integer.parseInt(spilt[1]);
    	
        if( a > b ) {
        	System.out.println(">");
        } else if( a < b ) {
        	System.out.println("<");
        } else {
        	System.out.println("==");
        }
    			
    }
}