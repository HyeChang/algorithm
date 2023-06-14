import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {

    	Scanner sc = new Scanner(System.in);
    	int A, B, C;
    	
    	while(true) {
    		
    		A = ( (A = sc.nextInt()) >= 2 ) ? A : 0;
    		B = ( (B = sc.nextInt()) <= 10000 ) ? B : 10001;
    		C = ( (C = sc.nextInt()) <= 10000 ) ? C : 10001;
    		
    		if( A == 0 || B == 10001 || C == 10001 ) {
    			System.out.println("Error");
    		} else {
    			break;
    		}
    		
    	}
    	
    	System.out.println( (A+B) % C );
    	System.out.println( ((A%C) + (B%C)) % C );
    	System.out.println( (A*B) % C );
    	System.out.println( ((A%C) * (B%C)) % C );
    	
    }

}