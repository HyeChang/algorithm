import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        int b100 = (b / 100);
        int b10 = (b / 10) - (b100 * 10);
        int b1 = b - (b10 * 10) - (b100 * 100);
        
        int resultOne = a * b1;
        int resultTwo = a * b10;
        int resultThree = a * b100;
        
        System.out.println(resultOne);
        System.out.println(resultTwo);
        System.out.println(resultThree);
        System.out.println( (resultOne + (resultTwo * 10) + (resultThree * 100)) );
		
    }
}