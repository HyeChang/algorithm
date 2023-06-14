import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	String input = br.readLine();
    	
    	int point = Integer.parseInt(input);
    	
    	int four = point % 4;
    	int hundred = point % 100;
    	int fourHundred = point % 400;
    	
        if( four == 0 && (!(hundred == 0) || fourHundred == 0) ) {
        	System.out.println("1");
        } else {
        	System.out.println("0");
        }
    	
    			
    }
}