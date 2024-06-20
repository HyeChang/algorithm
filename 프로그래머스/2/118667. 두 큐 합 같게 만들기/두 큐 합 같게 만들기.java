import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int answer = -1;
        int result = 0;
        int que1EndCursor = queue1.length - 1;
        int que2EndCursor = queue2.length - 1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long que1Sum = 0;
        long que2Sum = 0;
        
        // 각 큐 전체 합 계산
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            que1Sum += queue1[i];
            que2Sum += queue2[i];
        }
        long midNum = (que1Sum + que2Sum) / 2;
        
        for(int i = 0; i < (queue1.length * 2) + 4; i++) {
            
            // 종료 조건
            if(que1Sum == que2Sum) {
                answer = result;
                break;
            }
            
            int temVal = 0;
            if(que1Sum > midNum) {
                temVal = q1.poll();
                q2.add(temVal);
                que1Sum -= temVal;
                que2Sum += temVal;
            } else if(que2Sum > midNum) {
                temVal = q2.poll();
                q1.add(temVal);
                que2Sum -= temVal;
                que1Sum += temVal;
            }
            
            result++;
            
        }
        
        return answer;
        
    }
}