import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        int topLen = topping.length;
        int[] arrayASize = new int[topLen];
        int[] arrayBSize = new int[topLen];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        
        // set = 서로다른 배열 개수 저장
        // Arrays = 앞, 뒤 잘랐을 때 각 개수
        int endCur = topLen - 1;
        for(int i = 0; i < topLen; i++) {
            
            setA.add(topping[i]);
            arrayASize[i] = setA.size();
            
            setB.add(topping[endCur - i]);
            arrayBSize[endCur - i] = setB.size();
            
        }
        
        // 조건 비교
        for(int i = 0; i < topLen - 1; i++) {
            
            if(arrayASize[i] == arrayBSize[i + 1]) {
                answer++;
            }
            
        }
        
        return answer;
        
    }
}