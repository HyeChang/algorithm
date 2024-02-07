import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        int[] answer = {0, 0, 0, 0};
        int[] inLine = new int[edges.length + 2];
        int[] outLine = new int[edges.length + 2];
        int[] checkNode = new int[edges.length + 2];
        
        // 노드에 연결 된 in, out 간선 개수
        for(int i = 0; i < edges.length; i++) {
            
            // in, out line
            outLine[edges[i][0]]++;
            inLine[edges[i][1]]++;
            checkNode[edges[i][0]] = 1;
            checkNode[edges[i][1]] = 1;
            
        }
        
        int startNode = 0;
        for(int i = 0; i < edges.length + 2; i++) {
            
            // 정점 노드 => 들어오는 간선 : 0, 나가는 간선 : 2 이상
            if(inLine[i] == 0 && outLine[i] >= 2) {
                startNode = i;
                answer[0] = i;
                break;
            }
            
        }
        
        int allGraphCNT = 0;
        // 정점 노드 기준 연결된 간선 찾기
        for(int i = 0; i < edges.length + 2; i++) {
            
            if(edges.length <= i) break;
            if(edges[i][0] == startNode) {
                allGraphCNT++;
                int nextNode = edges[i][1];
                // 정점 노드 간선 제거
                inLine[nextNode]--;
            }
                
        }
        
        inLine[startNode] = 0;
        outLine[startNode] = 0;
        checkNode[startNode] = 0;
        
        /*** 그래프 판단 ***/
        for(int i = 0; i < edges.length + 2; i++) {
            
            // 막대 그래프
            if(inLine[i] == 0 && checkNode[i] == 1) {
                answer[2]++;
            }
            
             // 8자 그래프
            if(inLine[i] == 2 && outLine[i] == 2) {
                answer[3]++;
            }
            
        }
        
        answer[1] = allGraphCNT - (answer[2] + answer[3]);
        
        return answer;
    }
}