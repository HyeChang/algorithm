import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> checkMap = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        
        int wantAllCNT = 0;
        // 정현이 원하는 제품, 개수를 Map에 매핑
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
            wantAllCNT += number[i];
        }
        
        int checkAllCNT = 0;
        // 열흘안 원하는 제품이 모두 포함하는지 확인
        for(int i = 0; i < discount.length; i++) {
            
            String curKey = discount[i];
            
            int curVal = checkMap.getOrDefault(curKey, 0);
            que.add(curKey);
            checkMap.put(curKey, curVal + 1);
            
            // 만약 원하는 항목이 있다면 전체 카운팅 증가
            if(wantMap.containsKey(curKey) && checkMap.get(curKey) <= wantMap.get(curKey)) {
                checkAllCNT++;
            }            
            
            // 초반 10회는 Queue에 들어가야 함
            if(que.size() == 10) {
                
                // 문제 조건에 맞을 시 결과값 증가
                if(checkAllCNT == wantAllCNT) answer++;
                
                String rmVal = que.poll();
                int temMapVal = checkMap.getOrDefault(rmVal, 0);
                checkMap.put(rmVal, temMapVal - 1);
                
                // 제거된 값이 필요한 항목이면 전체 CNT 감소
                // 방금 제거된 Key값이 wantMap에 포함된 Key 개수보다 작을 때 전체 개수 감소
                // 같거나 크면 제거된 Key 개수가 감소 되어도 문제 조건에 영향 X
                if(wantMap.containsKey(rmVal) && checkMap.get(rmVal) < wantMap.get(rmVal)) {
                    checkAllCNT--;
                }
                
            }
            
        }
        
        return answer;
        
    }
}