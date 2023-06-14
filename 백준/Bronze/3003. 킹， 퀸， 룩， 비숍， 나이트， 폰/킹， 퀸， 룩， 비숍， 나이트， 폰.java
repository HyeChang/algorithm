import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuffer sb = new StringBuffer();
    	int chess[] = {1, 1, 2, 2, 2, 8};
    	String str = br.readLine();
    	String arr[] = str.split(" ");
    	
    	for( int i=0; i<6; i++ ) {
    		int input = Integer.parseInt(arr[i]);
    		sb.append( chess[i] - input ).append(" ");
    	}
    	
    	System.out.println(sb);
    	
    }

}
