import java.util.*;

class Solution {
	
	static boolean[] visitCheck;
	static int diceLength;
	static List<int[]> diceList;
	
	static List<Integer> diceASumList;
	static List<Integer> diceBSumList;
	
    public static int[] solution(int[][] dice) {
    	
    	diceLength = dice.length;
    	int[] answer = new int[diceLength / 2];
    	
    	visitCheck = new boolean[diceLength];
    	diceList = new ArrayList<>();
    	
    	/* A가 뽑을 수 있는 모든 전체 조합 */
    	int[] resultArry = new int[diceLength / 2];
    	Permutation(0, 0, resultArry);
    	
    	int maxSum = 0;
    	for(int[] diceA : diceList) {
    		int[] diceB = new int[diceLength / 2];
    		
    		// B 주사위 Number Check
    		LeftDiceNum(diceA, diceB);
    		
    		/* A, B dice 조합 확인 */
    		diceASumList = new ArrayList<>();
    		diceBSumList = new ArrayList<>();
    		
    		DiceCheck(0, diceA, dice, 0, diceASumList); // A 인원 전체 경우의 수
    		DiceCheck(0, diceB, dice, 0, diceBSumList); // A 인원 전체 경우의 수
    		
    		// 오름차순 정렬
    		Collections.sort(diceASumList);
    		Collections.sort(diceBSumList);
    		
    		/* 이진탐색으로 승리 개수 확인 */
    		List<Integer> diceAWinCntArry = new ArrayList<>();
    		int totalWinCNT = 0;
    		for(int diceANum : diceASumList) {
    			
    			int left = 0;
    			int right = diceBSumList.size();
    			
    			while(left + 1 < right) {
    				int mid = (left + right) / 2;
    				
    				if(diceANum > diceBSumList.get(mid)) {
    					left = mid;
    				} else {
    					right = mid;
    				}
    				
    			} // while
    			
    			totalWinCNT += left + 1;
    			
    		} // for : 이진탐색
    		
    		if(maxSum < totalWinCNT) {
    			maxSum = totalWinCNT;
    			
    			for(int i = 0; i < diceA.length; i++) {
    				answer[i] = diceA[i] + 1;
    			}
    			
    		}
    		
    	} // for diceA : diceList
    	
        return answer;
        
    }
    
    // 주사위 조합 check
    public static void DiceCheck(int index, int[] deiceArry, int[][] dice, int sum, List<Integer> diceSumList) {
    	
    	if(index >= diceLength / 2) {
    		diceSumList.add(sum);
    		return;
    	}
    	
		for(int i=0; i<6; i++) {
			DiceCheck(index + 1, deiceArry, dice, sum + dice[deiceArry[index]][i], diceSumList);
		}
    	
    }
    
    // 가능한 A 주사위 조합 확인
    public static void Permutation(int diceA, int index, int[] resultArry) {

    	// 종료 조건
    	if(diceA >= (diceLength / 2)) {
    		diceList.add(resultArry.clone());
    		return;
    	}

    	for(int i = index; i < diceLength; i++) {
    		/* n = 4 일 경우 index : 0 ~ 3 | 1 ~ 3 | 2 ~ 3 | 3
    		 * 			   diceA : 0 ~ 1
    		 * */
    		if(!visitCheck[i]) {
    			visitCheck[i] = true;
    			resultArry[diceA] = i;
    			Permutation(diceA + 1, i + 1, resultArry);
    			visitCheck[i] = false;
    		}
    		
    	}
    	
    } // Permutation
    
    // B 주사위 확인
    public static void LeftDiceNum(int[] A, int[] B) {
		
    	int index = 0;
    	boolean[] visit = new boolean[diceLength];
    	
    	for(int a : A) {
    		visit[a] = true;
    	}
    	
    	for(int i = 0; i < diceLength; i++) {
    		if(!visit[i]) {
    			B[index++] = i;
    		}
    	}
    	
	} // DiceNumCheck
    
}