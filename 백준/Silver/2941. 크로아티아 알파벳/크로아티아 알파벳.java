import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArry = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String inputStr = br.readLine();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		boolean checkFlag = false;
		
		for( int i=0; i<inputStr.length(); i++ ) {
			
			sb.setLength(0);
			
			for( int j=0; j<3; j++ ) {
				
				int scan = i + j;
				
				if( scan >= inputStr.length() ) break;
				
				char ca = inputStr.charAt(scan);
				
				sb.append(ca);
				
				boolean stringChk = Arrays.asList(strArry).contains(sb.toString());
				if( stringChk == true ) {
					count++;
					i = i + j;
					checkFlag = true;
					break;
				}
			}
			
			if( checkFlag == false ) {
				count++;
			} else {
				checkFlag = false;
			}
			
		}
		
		System.out.println(count);
		
		br.close();
	}
}