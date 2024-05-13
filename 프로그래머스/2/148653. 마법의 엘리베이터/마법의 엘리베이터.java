import java.util.*;

class Solution {
    public int solution(int storey) {
        
        int answer = 0;
        int numFlag = 1;
        
        int num = storey;
        
        while(num > 0) {
            
            int lastNum = num % 10;
            
            if(lastNum > 0) {
                // x > 5 일때 1 자리수 0이 될때까지 증가    
                if(lastNum > 5) {

                    answer += (10 - lastNum);
                    // 다음 자리수 계산
                    num += (10 - lastNum);

                } else if(lastNum < 5) { // x < 5 일때 1자리수 0이 될때까지 감소

                    answer += lastNum;
                    num -= lastNum;
                    
                } else { // 올림수를 포함한 다음 자리수가 5이상 일 때, 다음 자리수를 더하는게 이득
                    
                    int nextNum = (num / 10) % 10; // 다음 자리수
                    
                    if(nextNum + 1 > 5) {
                        answer += lastNum;
                        num += lastNum;
                    } else {
                        answer += lastNum;
                        num -= lastNum;
                    }
                    
                }
            }
            
            num /= 10;
            
        } // for
        
        return answer;
        
    }
}