import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	String input = br.readLine();
    	
    	int point = Integer.parseInt(input);
    	
    	if( point >= 90 ) {
        	System.out.println("A");
        } else if( point >= 80 && point < 90 ) {
        	System.out.println("B");
        } else if( point >= 70 && point < 80 ) {
        	System.out.println("C");
    	} else if( point >= 60 && point < 70 ) {
	    	System.out.println("D");
		} else {
			System.out.println("F");
		}
    			
    }
}