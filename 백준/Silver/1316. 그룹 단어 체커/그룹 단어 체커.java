import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNum = br.readLine();

        int numLength = Integer.parseInt(inputNum);
        
        int resultCnt = numLength;
        
        // 입력 개수
        for( int i=0; i<numLength; i++ ) {
        	
        	// 단어 입력
        	String inputStr = br.readLine();
        	int inputStrLen = inputStr.length();
        	boolean groupTextFlag = false;
        	
        	// 단어 그룹 체크
        	for( int j=0; j<inputStrLen; j++ ) {
        		char targetChar = inputStr.charAt(j);
        		// 비교 플래그
        		boolean trueFlag = false;
        		boolean falseFlag = false;
        		
        		// 단어 비교
        		int forCnt = j+1;
        		for( int p=forCnt; p<inputStrLen; ) {
        			if( forCnt >= inputStrLen ) {
        				break;
        			}
        			
        			char compareChar = inputStr.charAt(forCnt);
        			
        			// 단어 비교
        			if( targetChar == compareChar ) { // 같으면
        				// 그룹 단어가 아닐경우
        				if( falseFlag == true ) {
        					groupTextFlag = true;
        					break;
        				}
        				trueFlag = true;
        			} else { // 다르면
        				falseFlag = true;
        			}
        			
        			forCnt++;
        			
        		}// for 단어비교
        		
        		// 그룹 단어가 아닐경우
        		if( groupTextFlag == true ) {
        			break;
        		}
        		
        	} // for 단어 그룹 체크
        	
        	// 그룹 단어가 아닐경우
        	if( groupTextFlag == true ) {
        		resultCnt--;
        	}
        	
        } // for 입력 개수
        
        System.out.println(resultCnt);
        
		br.close();
	}
	
}