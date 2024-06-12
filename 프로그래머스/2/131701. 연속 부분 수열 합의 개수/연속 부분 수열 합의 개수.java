import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int answer = 0;
        int elementsLen = elements.length;
        HashSet<Integer> setElements = new HashSet<>();
        int[] cycleElements = new int[elementsLen * 2];
        
        // 순환배열 위해서 크기 두배로 새로 선언
        for(int i = 0; i < elementsLen; i++) {
            cycleElements[i] = elements[i];
            cycleElements[i + elementsLen] = elements[i];
        }
        
        // 1 부터 elementsLen 까지 증가하며 순서대로 더해줌
        for(int i = 1; i <= elementsLen; i++) {
            for(int j = 0; j < elementsLen; j++) {
                
                setElements.add(Arrays.stream(cycleElements, j, j + i).sum());
                
            }
        }
        
        answer = setElements.size();
        return answer;
        
    }
}