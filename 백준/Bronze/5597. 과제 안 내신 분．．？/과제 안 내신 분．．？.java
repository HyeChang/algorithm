import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inputArr = new ArrayList<>();
		
		for( int i=0; i<28; i++ ) {
			int input = Integer.parseInt(br.readLine());
			inputArr.add(input);
		}
		
		for( int i=1; i<=30; i++ ) {
			if( inputArr.indexOf(i) < 0 ) {
				System.out.println(i);
			}
		}

		br.close();
	}
}