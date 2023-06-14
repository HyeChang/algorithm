import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] split = br.readLine().split(" ");
    	
    	int h = Integer.parseInt(split[0]);
    	int m = Integer.parseInt(split[1]);
    	int inputTime = Integer.parseInt(br.readLine());
    	
		int allM = (h * 60) + m + inputTime;
		h = allM / 60;
		m = allM % 60;
		
		if(h >= 24) {
			h = h - 24;
		}
		
		System.out.println(h + " " + m);
    	
    }
}