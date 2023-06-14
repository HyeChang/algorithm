import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] split = br.readLine().split(" ");
    	
    	int h = Integer.parseInt(split[0]);
    	int m = Integer.parseInt(split[1]);
    	
    	if(m >= 45) {
    		m = m - 45;
    	} else if(m < 45) {
    		m = m - 45;
    		m = 60 + m;
    		if(h == 0) {
    			h = 23;
    		} else {
    			h = h - 1;
    		}
    	}
    	System.out.println(h + " " + m);
    			
    }
}