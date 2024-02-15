import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 두번쨰 숫자 기준 오름차순 정렬
        Arrays.sort(targets, Comparator.comparingInt((int[] o) -> o[1]));
        
        // 기준 숫자
        int lastNum = targets[0][1];
        answer++;
        
        for(int[] t : targets) {
            // 마지막 숫자 기준 다음 첫번째 숫자와 비교
            if(t[0] >= lastNum) {
                lastNum = t[1];
                answer++;
            }
        }
        
        return answer;
    }
}