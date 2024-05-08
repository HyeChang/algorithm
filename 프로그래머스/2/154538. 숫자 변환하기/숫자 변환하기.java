import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        que.add(x);
        visited.add(x);
        // bfs
        while(!que.isEmpty()) {
            
            int size = que.size();
            
            for(int i = 0; i < size; i++) {
                
                int cursor = que.poll();
            
                if(cursor == y) {
                    return answer;
                }

                if((cursor + n) <= y && !visited.contains(cursor + n)) {
                    que.add(cursor + n);
                    visited.add(cursor + n);
                }
                if((cursor * 2) <= y && !visited.contains(cursor * 2)) {
                    que.add(cursor * 2);
                    visited.add(cursor * 2);
                }
                if((cursor * 3) <= y && !visited.contains(cursor * 3)) {
                    que.add(cursor * 3);
                    visited.add(cursor * 3);
                }
                
            }
            answer++;
        } // while
        
        return -1;
        
    }
    
}