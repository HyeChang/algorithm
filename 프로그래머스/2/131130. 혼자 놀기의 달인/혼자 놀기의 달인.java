import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int cardsLen = cards.length;
        boolean[] visited = new boolean[cardsLen];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < cardsLen; i++) {
            
            if(visited[i]) continue;
            
            pq.add(getResult(i, cards, visited));
            
        }
        
        if(pq.size() < 2) {
            return 0;
        } else {
            answer = pq.poll() * pq.poll();
            return answer;    
        }
        
    }
    
    // bfs
    private int getResult(int startNum, int[] cards, boolean[] visited) {
        
        Queue<Integer> que = new LinkedList<>();
        que.add(startNum);
        visited[startNum] = true;
        int openCnt = 1;
        
        // 모든 그룹 확인을 판단하는 조건
        while(!que.isEmpty()) {
            
            int curNum = que.poll();
            int nextBox = cards[curNum] - 1;
            
            if(visited[nextBox]) continue;
            
            que.add(nextBox);
            openCnt++;
            visited[nextBox] = true;
            
        }
        return openCnt;
    }
    
}