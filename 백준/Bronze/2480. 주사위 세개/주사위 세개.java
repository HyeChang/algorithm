import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] split = br.readLine().split(" ");
    	
    	int a = Integer.parseInt(split[0]);
    	int b = Integer.parseInt(split[1]);
    	int c = Integer.parseInt(split[2]);
    	
    	if(a == b && a == c) {
    		System.out.println(10000 + (a*1000));
    	} else if(a == b || a == c) {
    		System.out.println(1000 + (a*100));
    	} else if(b == c) {
    		System.out.println(1000 + (b*100));
    	} else {
    		System.out.println( Math.max(a, Math.max(b, c)) * 100 );
    	}
    	
    }
}