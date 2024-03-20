import java.util.*;

class Solution {
    
    private final char EXIT = 'E';
	private final char START = 'S';
	private final char LEVER = 'L';
	private final char DEADX = 'X';
	
	private int[][] visited;
	private int[][] visitTime;
	private int[] rootX = {1, -1, 0, 0};
	private int[] rootY = {0, 0, 1, -1};
	
	private int depth;
	private int width;
	
	private class Move {
		int x, y;
		
		public Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
    
    public int solution(String[] maps) {
        
        int answer = 0;
        depth = maps.length;
        width = maps[0].length();
        visited = new int[depth][width];
        visitTime = new int[depth][width];
        
        Move exit = null;
        Move lever = null;
        Move start = null;
        
        // 1. 시작지점, 레버, 출구위치 확인
        for(int i = 0; i < depth; i++) {
        	for(int j = 0; j < width; j++) {
        		
        		Character ch = maps[i].charAt(j);
        		
        		if(ch == EXIT) {
        			exit = new Move(i, j);
        		} else if(ch == START) {
        			start = new Move(i, j);
        		} else if(ch == LEVER) {
        			lever = new Move(i, j);
        		}
        		
        	}
        }
        
        // 2. Lever 위치 최단 거리 or BFS에서 레버 거치고 가도록 코드 짜기
        int leverBfsTime = bfs(maps, lever, start);
        if(leverBfsTime == -1) return -1;
        // 3. Lever 위치에서 출구 까지 최단 거리
        visited = new int[depth][width];
        int resultTime = bfs(maps, exit, lever);
        
        return resultTime;
        
    }
    
    private int bfs(String[] maps, Move end, Move start) {
		
		Queue<Move> que = new LinkedList<>();
		visited[start.x][start.y] = 1;
		que.add(start);
		
		while(!que.isEmpty()) {
			
			Move currentQue = que.poll();
			
			if(currentQue.x == end.x && currentQue.y == end.y) {
				return visitTime[currentQue.x][currentQue.y];
			}
			
			for(int i = 0; i < 4; i++) {

				int x = currentQue.x + rootX[i];
				int y = currentQue.y + rootY[i];
				
				
				// 끝에 도달 시 스킵
				if(x < 0 || y < 0 || x >= depth || y >= width) {
					continue;
				}
				
				if(maps[x].charAt(y) != DEADX && visited[x][y] != 1) {
					visitTime[x][y] = visitTime[currentQue.x][currentQue.y] + 1;
					visited[x][y] = 1;
					que.add(new Move(x, y));
				}
				
			} // for
			
		} // while
		
		return -1;
	}
    
}