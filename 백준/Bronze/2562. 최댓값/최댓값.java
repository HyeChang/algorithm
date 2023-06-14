import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inputArr = new ArrayList<>();
        int temp = 0;
        int number = 0;
		
		for( int i=0; i<9; i++ ) {
			int input = Integer.parseInt(br.readLine());
			inputArr.add(input);
		}
		
		for( int i=0; i<inputArr.size(); i++ ) {
			int arrNum = inputArr.get(i);
			
			if( arrNum > temp ) {
				temp = arrNum;
				number = i;
			}
		}
		System.out.println(temp);
		System.out.println(number+1);
		
		br.close();
	}
}