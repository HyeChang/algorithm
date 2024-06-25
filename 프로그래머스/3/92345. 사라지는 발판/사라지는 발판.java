import java.util.*;

class Move {
        private boolean isWin;
        private int moveCnt;
        
        public Move(boolean isWin, int moveCnt) {
            this.isWin = isWin;
            this.moveCnt = moveCnt;
        }
        
        public boolean getIsWin() {
            return isWin;
        }
        
        public int getMoveCnt() {
            return moveCnt;
        }
        
    }

class Solution {
    
    private int[] mx = {1, 0, -1, 0};
    private int[] my = {0, 1, 0, -1};
    
    private int row, col;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        
        int answer = -1;
        col = board.length;
        row = board[0].length;
        
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]).getMoveCnt();
        
    }
    
    private Move dfs(int[][] board, int ax, int ay, int bx, int by) {
        
        // 이동할 수 없는 경우
        if (isEnded(board, ax, ay)) {
            return new Move(false, 0);
        }
        // 같은 발판위에 있는 경우 = 현재 플레이어가 이긴다(한번 움직임)
        if (ax == bx && ay == by) {
            return new Move(true, 1);
        }
        
        // 승리하는 경우 판단
        boolean canWin = false;
        // 승리하는 경우가 없을 때 최대한 오래 버틴 Cnt
        int maxMove = -1;
        // 승리하는 경우가 있을 때 최소 이동 거리
        int minMove = Integer.MAX_VALUE;
        // 처음 이동 발판 제거
        board[ax][ay] = 0;
        
        // 4방향으로 움직임
        for(int i = 0; i < 4; i++) {
            int nx = ax + mx[i];
            int ny = ay + my[i];
            
            // 다음 발판이 없다면 pass
            if ((nx < 0 || ny < 0 || nx >= col || ny >= row) || board[nx][ny] == 0) {
                continue;
            }
            
            // 현재 플레이어 A 일 때 다음 플레이어인 B 플레이어로 재귀 호출
            Move nextMove = dfs(board, bx, by, nx, ny);
            
            // 상대 플레이어가 이김 == 현재 플레이어 패배 == 현재 플레이어는 최대 이동 필요
            if (nextMove.getIsWin()) {
                maxMove = Math.max(maxMove, nextMove.getMoveCnt());
            } 
            // 상대 플레이어가 짐 == 현재 플레이어 최소 이동
            else {
                canWin = true;
                minMove = Math.min(minMove, nextMove.getMoveCnt());
            }
        }
        
        // 재귀에 나오기 위해 발판 원위치
        board[ax][ay] = 1;
        
        return new Move(canWin, (canWin ? minMove : maxMove) + 1);
    }
    
    // 다음 이동 가능여부 확인(다음 발판 확인)
    private boolean isEnded(int[][] board, int x, int y) {
        for(int i = 0; i < 4; i++) {
            int temX = x + mx[i];
            int temY = y + my[i];
            
            if ((temX >= 0 && temY >= 0 && temY < row && temX < col) && board[temX][temY] == 1) {
                return false;
            }
        }
        return true;
    }
    
}