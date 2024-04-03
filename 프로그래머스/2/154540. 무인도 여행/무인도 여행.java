import java.util.*;

class Solution {
    
    private final Character SEA = 'X';
	private boolean[][] visited;
	
	private int[] rootX = {1, -1, 0, 0};
	private int[] rootY = {0, 0, 1, -1};
	
	private int mapLen;
	private int mapWidth;
	
	class Move {
		int x, y;
		
		public Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public List<Integer> solution(String[] maps) {
		
		List<Integer> answer = new ArrayList<>();
        mapLen = maps.length;
        mapWidth = maps[0].length();
        
        visited = new boolean[mapLen][mapWidth];
        
        for(int i = 0; i < mapLen; i++) {
        	for(int j = 0; j < mapWidth; j++) {
        		
        		Character ch = maps[i].charAt(j);
        		
        		if(!visited[i][j] && ch != SEA) {
        			answer.add(bfs(maps, i, j));
        		}
        		
        	}// for
        }
        
        if(answer.size() <= 0) {
        	answer.add(-1);
        	return answer;
        }
        
        // 내림차순 정렬
        Collections.sort(answer);
        
        return answer;
        
    }
	
	private int bfs(String[] maps, int mapX, int mapY) {
		
		Queue<Move> que = new LinkedList<>();
		visited[mapX][mapY] = true;
		que.add(new Move(mapX, mapY));
		int sum = 0;
		
		while(!que.isEmpty()) {
			
			Move courrentQue = que.poll();
			int x = courrentQue.x;
			int y = courrentQue.y;
			sum += maps[x].charAt(y) - '0';
            
			for(int i = 0; i < 4; i++) {
				
				int qx = x + rootX[i];
				int qy = y + rootY[i];
				
				// 땅 끝인 경우 pass
				if(qx < 0 || qy < 0 || qx >= mapLen || qy >= mapWidth) {
					continue;
				}
				
				// 방문 안했으며, 바다가 아닌 경우 큐에 추가
				if(maps[qx].charAt(qy) != SEA && !visited[qx][qy]) {
					visited[qx][qy] = true;
					que.add(new Move(qx, qy));
				}
				
			}// for
			
		}
        
		return sum;
        
	}
}