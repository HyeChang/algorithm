import java.util.*;

class Solution {
    
    private final Character ROBOT = 'R';
	private final Character GOAL = 'G';
	private final Character DEAD = 'D';
	
	private int[][] visited;
	private int[] drctmoveX = {1, -1, 0, 0};
	private int[] drctmoveY = {0, 0, 1, -1};
	
	private int depth;
	private int width;
    
    private class Move {
		int x, y, count;
		
		public Move(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
    
    public int solution(String[] board) {
        
        int answer = 0;
        depth = board.length;
        width = board[0].length();
        
        Move robot = null;
        Move goal = null;

        visited = new int[depth][width];
        
        // GOAL, ROBOT 위치 확인
        for(int i= 0; i < depth; i++) {
        	for(int j = 0; j < width; j++) {
        		
        		Character ch = board[i].charAt(j);
        		
        		if(ch == ROBOT) {
        			robot = new Move(i, j, 0);
        		} else if(ch == GOAL) {
        			goal = new Move(i, j, 0);
        		}
        		
        	}
        }
        
        answer = bfs(board, robot, goal);
        
        return answer;
        
    }
    
    // BFS
    private int bfs(String[] board, Move robot, Move goal) {
    	
    	Queue<Move> que = new LinkedList<>();
    	visited[robot.x][robot.y] = 1;
    	que.add(robot);
    	
    	while(!que.isEmpty()) {
    		
    		Move strPt = que.poll();
    		
    		if(strPt.x == goal.x && strPt.y == goal.y) {
				return strPt.count;
			}
    		
    		for(int i = 0; i < 4; i++) {
    			int x = strPt.x;
    			int y = strPt.y;
    			
    			// 끝에 도달 하거나 'D' 지나면 중지
    			while(x >= 0 && y >= 0 && x < depth && y < width && board[x].charAt(y) != DEAD ) {
    				
    				x += drctmoveX[i];
    				y += drctmoveY[i];
    				
    			} // while
    			
    			// 막히기 이전 값에서 길찾기 시작
    			x -= drctmoveX[i];
    			y -= drctmoveY[i];
    			
    			// 방문 기록이 있거나 같은 위치 일때 스킵
    			if(visited[x][y] == 1 || (strPt.x == x && strPt.y == y)) {
    				continue;
    			}
    			
    			visited[x][y] = 1;
    			que.add(new Move(x, y, strPt.count + 1));
    			
    		} // for
    		
    	} // while
    	
    	return -1;
    	
    } // BFS
    
}