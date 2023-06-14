import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> resultArry = new ArrayList<>(); 
		
		String inputCase = br.readLine();
		
		int inputNum = Integer.parseInt(inputCase);
		
		for( int r=0; r<inputNum; r++ ) {
			
			String[] inputData = br.readLine().split(" ");
			int studentNum = Integer.parseInt(inputData[0]);
			int allScore = 0;
			
			for( int i=1; i<=studentNum; i++ ) {
				
				allScore += Integer.parseInt(inputData[i]);
				
			}
			
			// 평균값
			int avg = (allScore / studentNum);
			int highAvgStudentCNT = 0;
			
			for( int j=1; j<=studentNum; j++ ) {
				
				int score = Integer.parseInt(inputData[j]);
				
				if( avg < score ) {
					highAvgStudentCNT++;
				}
				
			}
			
			double result = ((double)highAvgStudentCNT / (double)studentNum) * 100;
			String resultTemp = String.format("%.3f", result) + "%";
			resultArry.add(r, resultTemp);
			
		}

		for( int n=0; n<resultArry.size(); n++ ) {
			System.out.println(resultArry.get(n));
		}
		
		br.close();
	}
}