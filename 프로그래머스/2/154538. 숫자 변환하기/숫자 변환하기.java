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

            // 연산 횟수
            for(int i = 0; i < size; i++) {

                int cur = que.poll();

                // y 찾을 시 바로 종료(최소)
                if(cur == y) return answer;

                // 조건 만족 시 다음 연산 수행을 위해 큐에 값 저장
                if( (cur + n) <= y && !visited.contains(cur + n) ) {
                    que.add(cur + n);
                    visited.add(cur + n);
                }
                if( (cur * 2) <= y && !visited.contains(cur * 2) ) {
                    que.add(cur * 2);
                    visited.add(cur * 2);
                }
                if( (cur * 3) <= y && !visited.contains(cur * 3) ) {
                    que.add(cur * 3);
                    visited.add(cur * 3);
                }

            }
            // 연산 횟수 증가
            answer++;

        }

        return -1;

    }
}