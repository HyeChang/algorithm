import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
    
        long answer = 0;
        long r1XPow = (long)Math.pow(r1, 2);
        long r2XPow = (long)Math.pow(r2, 2);
        
        /* 원 안 정수쌍 구하는 공식 : y^2 = r^2 - x^2
         * y = √(r^2 - x^2)
         * */ 
        for(int i = 0; i <= r2; i++) {
            
            long y1 = (long)Math.sqrt(r1XPow - (long)Math.pow(i, 2));
            long y2 = (long)Math.sqrt(r2XPow - (long)Math.pow(i, 2) );
            
            // side 판단
            if( Math.sqrt(r1XPow - (long)Math.pow(i, 2)) % 1 == 0 ) {
                answer += 4;
            }
            
            answer += (y2 - y1) * 4;
            
        }
            
        return answer - 4;
        
    }
}
