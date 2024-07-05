class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int row = board.length;
        int col = board[0].length;
        int answer = 0;
        int[][] sum = new int[row + 1][col + 1];
        
        // 누적합 기준 결정
        for(int[] s : skill) {
            
            int skillDegree = (s[0] == 1 ? (s[5] * -1) : s[5]);
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            
            sum[y1][x1] += skillDegree;
            sum[y2 + 1][x2 + 1] += skillDegree;
            sum[y2 + 1][x1] += (skillDegree * -1);
            sum[y1][x2 + 1] += (skillDegree * -1);
            
        }
        
        /**
            누적합 계산
        */
        // 왼 -> 오
        for(int y = 0; y < row + 1; y++) {
            for(int x = 0; x < col; x++) {
                sum[y][x + 1] += sum[y][x];
            }
        }
        // 위 -> 아래
        for(int x = 0; x < col + 1; x++) {
            for(int y = 0; y < row; y++) {
                sum[y + 1][x] += sum[y][x];
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        
        return answer;
        
    }
}