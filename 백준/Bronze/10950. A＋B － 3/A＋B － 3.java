import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] split = br.readLine().split(" ");
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	int input = Integer.parseInt(split[0]);
    	
    	for(int i=0; i<input; i++) {
    		split = br.readLine().split(" ");
    		
    		int a = Integer.parseInt(split[0]);
        	int b = Integer.parseInt(split[1]);
        	
        	result.add(a+b);
        	
    	}
    	for(Integer i : result) {
    		System.out.println(i);
    	}
    }
}