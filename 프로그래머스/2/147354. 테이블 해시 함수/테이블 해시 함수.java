import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int answer = 0;
        int dataLen = data[0].length;
        
        // 정렬(오름)
        // 조건. 중복일 경우 첫번째 값으로 비교(내림)
        Arrays.sort(data, Comparator.comparingInt( (int[] o) -> o[0] ).reversed());
        Arrays.sort(data, Comparator.comparingInt( (int[] o) -> o[col - 1] ));
        
        int[] arrS = new int[(row_end - row_begin) + 1];
        // begin end 계산
        int index = 0;
        for(int i = row_begin; i <= row_end; i++) {
            
            // S_i 계산
            for(int j = 0; j < dataLen; j++) {
                
                arrS[index] += data[i - 1][j] % i;
                
            }
            index++;
        }
        
        // XOR 연산
        int head = arrS[0];
        for(int i = 1; i < arrS.length; i++) {
            
            int cur = arrS[i];
            
            // 연산
            head = (head ^ cur);
            //head = cur;
            
        }
        answer = head;
        return answer;
        
    }
}