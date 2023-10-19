import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> inputList = new ArrayList<>();
		int T = 0;
		
		// input
		while(true) {
			T = Integer.parseInt(br.readLine());
			if(T == -1) break;
			inputList.add(T);
		}
		
		for(int t=0; t<inputList.size(); t++) {
			
			int inputNum = inputList.get(t);
			int addNum = 1;
			
			ArrayList<Integer> resultList = new ArrayList<>();
			
			int sqrtInt = (int)Math.sqrt(inputNum);
			
			for(int i=sqrtInt; i>1; i--) {
				int sqrtResult = inputNum % i;
				
				if(sqrtResult == 0) {
					int divideResult = inputNum / i;
                    
					resultList.add(i);
					addNum += i;
                    
					if(!resultList.contains(divideResult)) {
						resultList.add(divideResult);
						addNum += divideResult;
					}
                    
				}
			}
			
			if(addNum == inputNum) {
                
				Collections.sort(resultList);
				System.out.print(inputNum + " = " + 1);
				for(int j=0; j<resultList.size(); j++) {
					System.out.print(" + " + resultList.get(j));
				}
                
			} else {
				System.out.print(inputNum + " is NOT perfect.");
			}
			
			System.out.println();
			
		};
		
	}
	
}