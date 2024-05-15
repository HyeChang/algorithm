import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        int answer = 0;
        int enemyLen = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 디펜스
        boolean defenseFlag = false;
        for(int i = 0; i < enemyLen; i++) {
            
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n < 0) {
                
                // 무적권(k)이 남아있고 큐에 값이 있다면 앞에서 부터 k 사용
                if(k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
                
            }
            
            if(i == (enemyLen - 1)) defenseFlag = true;
            
        }
        
        if(defenseFlag == true) answer = enemyLen;
        
        return answer;
        
    }
}