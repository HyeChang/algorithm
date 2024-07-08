public class Solution {
    
	static private int[] answer = {-1};
	static private int max = Integer.MIN_VALUE; // 최대값
    
    public static int[] solution(int n, int[] info) {
        
        int infoLen = info.length;
        int[] ryanResult = new int[11];
        
        back(0, n, info, ryanResult); // 라이언이 쏜 화살에 대한 조합
        
        // 라이언이 어피치를 못 이길떄
        if (max == -1) {
        	answer = new int[1];
        	answer[0] = -1;
        }
        
        return answer;
        
    }
    
    public static void back(int depth, int n, int[] info, int[] ryanResult) {
    	// 화살 다 꽂았을때(종료조건)
    	if (depth == n) {
    		int diff = score(info, ryanResult); // 점수차 구하기
    		if (max <= diff) { // 점수차 최대값 갱신
    			max = diff;
    			answer = ryanResult.clone();
    		}
    		return;
    	}
        
    	for(int i = 0; i < info.length; i++) {
            
            // i 과녁에 라이언이 화살을 더 많이 맞추면 반복문 종료(백트래킹 조건)
            if (ryanResult[i] > info[i]) break;
            
    		ryanResult[i] += 1;
    		back(depth + 1, n, info, ryanResult);
    		ryanResult[i] -= 1;
    	}
    }
    
    // 점수차 구하기
    public static int score(int[] info, int[] ryanResult) {
    	int apeach = 0, ryan = 0;
        
    	for(int i = 0; i < ryanResult.length; i++) {
            
            // 둘다 0개 맞췄을땐 무시
    		if(info[i] == 0 && ryanResult[i] == 0) continue;
            
    		if(info[i] >= ryanResult[i]) apeach += (10 - i);
            
    		else ryan += (10 - i);
    	}
    	
    	int diff = ryan - apeach;
    	if (diff <= 0) return -1;
    	return diff;
    }
}