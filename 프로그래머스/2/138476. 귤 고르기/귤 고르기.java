import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        Map<Integer, Integer> tanMap = new HashMap<>();
        int tanLen = tangerine.length;
        
        for(int i = 0; i < tanLen; i++) {
            
            int tempVal = tanMap.getOrDefault(tangerine[i], -1);
            
            // 매칭 되는 값이 있다면 cnt++
            // 없으면 cnt=1로 새로 생성
            if(tempVal == -1) {
                tanMap.put(tangerine[i], 1);
            } else {
                tanMap.put(tangerine[i], tempVal + 1);
            }
            
        }
        
        // val 순으로 정렬
        List<Map.Entry<Integer, Integer>> sortMap = new LinkedList<>(tanMap.entrySet());
        
        sortMap.sort( (o1, o2) -> tanMap.get(o2.getKey()) - tanMap.get(o1.getKey()) );
        
        for(Map.Entry<Integer, Integer> entry : sortMap){
            if(k <= 0) break;
            
            k -= entry.getValue();
            answer++;
        }
        
        return answer;
        
    }
}