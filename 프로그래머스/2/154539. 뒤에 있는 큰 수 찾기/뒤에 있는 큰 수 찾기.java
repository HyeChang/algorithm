import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int numberLen = numbers.length;
        int[] answer = new int[numberLen];
        Stack<Integer> st = new Stack<>(); 
        
        st.push(0);
        
        for(int i = 1; i < numberLen; i++) {
    		
        	// 스택에 index가 있고 스택 index 값보다 다음 수가 클 때 현재값 저장 
        	while(!st.empty() && numbers[st.peek()] < numbers[i]) {
        		answer[st.pop()] = numbers[i];
        	}
        	
        	st.push(i);
        	
        } // for
        
        // 큰 수 없는 나머지 숫자들 -1 처리
        while(!st.empty()) {
        	answer[st.pop()] = -1;
        }
        
        return answer;
        
    }
}