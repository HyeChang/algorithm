import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputNum = br.readLine();
		int inputNumInt = Integer.parseInt(inputNum);
		
		int blankFor = inputNumInt - 1;
		int startFor = 1;
		
		for( int a=0; a<inputNumInt + (inputNumInt-1); a++ ) {
			
			for( int i=0; i<blankFor; i++ ) {
				System.out.print(" ");
			}
			
			for( int j=0; j<startFor; j++ ) {
				System.out.print("*");
			}
			
			if( a >= inputNumInt-1 ) {
				startFor = startFor - 2;
				blankFor = blankFor + 1;
			} else {
				startFor = startFor + 2;
				blankFor = blankFor - 1;
			}
			System.out.println("");
		}
			
		br.close();
	}
}