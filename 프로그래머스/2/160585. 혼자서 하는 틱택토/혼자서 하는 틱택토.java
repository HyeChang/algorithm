import java.util.*;

class Solution {
    public static int solution(String[] board) {
        
		int answer = -1;
        String[] bingGoNum = {"012", "345", "678", "036", "147", "258", "048", "246"};
        StringBuilder bigGoStrO = new StringBuilder();
        StringBuilder bigGoStrX = new StringBuilder();
        int bingGoCheckO = 0;
        int bingGoCheckX = 0;
        int index = 0;
        char[] charArry = new char[9];
        
        // 배열 이동 및 빙고 배열 저장
        int doubleCheck = 0;
        for(int i=0; i<board.length; i++) {
            
            String tempA = board[i];
            
            for(int a=0; a<3; a++) {
                
            	charArry[index] = tempA.charAt(a);
                if(tempA.charAt(a) == 'O') {
                    bigGoStrO.append(index);
                } else if(tempA.charAt(a) == 'X') {
                	bigGoStrX.append(index);
                }
                index++;
            }
            
        }
        
        bingGoCheckO = BingGoCheck(bigGoStrO, bingGoNum, bingGoCheckO);
        bingGoCheckX = BingGoCheck(bigGoStrX, bingGoNum, bingGoCheckX);
       
        //'X'가 'O'보다 많으면 규칙 위반
        if (bigGoStrX.length() > bigGoStrO.length()) {
            return 0;
        }
        
        //'O'가 'X'보다 2개이상 많으면 규칙 위반
        if (bigGoStrO.length() > (bigGoStrX.length() + 1)) {
            return 0;
        }
        
        if(bingGoCheckO >= 1) {
            if(bigGoStrO.length() == bigGoStrX.length()) {
                return 0;
            }
        }
        
        if(bingGoCheckX >= 1) {
            if(bigGoStrO.length() == (bigGoStrX.length() + 1)) {
                return 0;
            }
        }
        
        return 1;
        
    }
	
	public static int BingGoCheck(StringBuilder str, String[] bingGoNum, int bingGoChec) {
		
		int strlength = str.length();
		StringBuilder tempSb = new StringBuilder();
		
		for(int i = 0; i < strlength - 2; i++) {
			tempSb.append(str.charAt(i));
			for(int j = i + 1; j < strlength - 1; j++) {
				tempSb.append(str.charAt(j));
				for(int n = i + 2; n < strlength; n++) {
					
					tempSb.append(str.charAt(n));
					// 1. 빙고 판단
			        for(int b=0; b<bingGoNum.length; b++) {
			             if(tempSb.indexOf(bingGoNum[b]) != -1) {
			            	 bingGoChec++;
			             }
			        }
			        tempSb.deleteCharAt(2);
				}
				tempSb.delete(1, tempSb.length());
			}
			tempSb.setLength(0);
		}
		
		return bingGoChec;
		
	}
    
}