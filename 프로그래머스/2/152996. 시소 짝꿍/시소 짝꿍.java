import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        long answer = 0;
        int wLen = weights.length;
        // 정렬
        Arrays.sort(weights);
        
        int cnt = 0;
        for(int i = 0; i < wLen - 1; i++) {
            
            // 중복제거
            if(i > 0) {
                if(weights[i] == weights[i - 1]) {
                    cnt--;
                    answer += cnt;
                    continue;
                }
            }
            cnt = 0;
            // 몸무게 조건 (2/1, 3/2, 4/3) 체크
            for(int j = i + 1; j < wLen; j++) {
                
                if( weights[i] == weights[j] ||
                    weights[i] * 2 == weights[j] ||
                    weights[i] * 3 == weights[j] * 2 ||
                    weights[i] * 4 == weights[j] * 3) {
                    cnt++;
                }
                
            }
            answer += cnt;
        }
        
        return answer;
        
    }
}