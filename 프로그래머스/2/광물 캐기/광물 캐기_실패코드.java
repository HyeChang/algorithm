import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;
        
        int minePicksNum = (int)Math.ceil(minerals.length / 5.0);
        int allMineNum = minerals.length;
        String[] picksOrder = new String[minePicksNum];
        Arrays.fill(picksOrder, "stone");
        
        Map<String, Map<Integer, Integer>> mineNumMap = new HashMap<>();
        mineNumMap.put("dia", new HashMap<>());
        mineNumMap.put("iron", new HashMap<>());
        
        int fiveCnt = 0;
        int index = 0;
        int diaIndex = 0;
        int ironIndex = 0;
        // 1. 다이아, 철 개수 개산 + 저장
        for(int i = 0; i < allMineNum; i++) {
        	
        	if(minerals[i].equals("diamond")) {
        		diaIndex++;
        	} else if(minerals[i].equals("iron")) {
        		ironIndex++;
        	}
        	
        	fiveCnt++;
        	if(fiveCnt == 5 || allMineNum - 1 == i) {
        		fiveCnt = 0;
        		mineNumMap.get("dia").put(index, diaIndex);
        		mineNumMap.get("iron").put(index, ironIndex);
        		diaIndex = 0;
        		ironIndex = 0;
        		index++;
        	}
        	
        } // for
        
        // 2. 곡괭이 순서 정하기
        /* 종료 조건
         * 1. 곡괭이 모두 소모
         * 2. 모든 광물 채광
         **/
        int diaPickNum = picks[0];
        int ironPickNum = picks[1];
        int stonePickNum = picks[2];
        int mineMaxNum = 0;
        int allPicksNum = diaPickNum + ironPickNum; // 돌 제외 곡괭이 수
        int diaNStonePicksNum = diaPickNum + stonePickNum; // 철 제외 곡괭이 수
        while(allPicksNum > 0) {
        	
        	if(mineMaxNum > minePicksNum || mineMaxNum >= minePicksNum) break;
        	
        	// 다이아 곡괭이
        	while(diaPickNum > 0 && mineMaxNum < minePicksNum){
        		int maxDiaMineVal = getMapVal(mineNumMap, "dia");
        		int maxDiaMineKey = getMapKey(mineNumMap, "dia");
        		int maxIronMineKey = getMapKey(mineNumMap, "iron");
        		
        		if(maxDiaMineVal != 0) {
        			picksOrder[maxDiaMineKey] = "diamond";
        			mineNumMap.get("dia").replace(maxDiaMineKey, 0);
        			mineNumMap.get("iron").replace(maxDiaMineKey, 0);
        			allPicksNum--;
        			diaPickNum--;
        		}
        		// 철 개수 확인
        		else {
        			picksOrder[maxIronMineKey] = "diamond";
        			mineNumMap.get("dia").replace(maxIronMineKey, 0);
        			mineNumMap.get("iron").replace(maxIronMineKey, 0);
        			allPicksNum--;
        			diaPickNum--;
        		}
        		mineMaxNum++;
        		
        	}
        	// 철 곡괭이
        	while(ironPickNum > 0 && mineMaxNum < minePicksNum){
        		int maxIronMineKey = getMapKey(mineNumMap, "iron");
        		int maxDiaMineVal = getMapVal(mineNumMap, "dia");
        		int maxDiaMineKey = getMapKey(mineNumMap, "dia");
        		// 다이아 우선 확인
        		if(maxDiaMineVal != 0) {
        			picksOrder[maxDiaMineKey] = "iron";
        			mineNumMap.get("dia").replace(maxDiaMineKey, 0);
        			mineNumMap.get("iron").replace(maxDiaMineKey, 0);
        			allPicksNum--;
        			ironPickNum--;
        		}
        		// 철 개수 확인
        		else {
        			picksOrder[maxIronMineKey] = "iron";
        			mineNumMap.get("dia").replace(maxIronMineKey, 0);
        			mineNumMap.get("iron").replace(maxIronMineKey, 0);
        			allPicksNum--;
        			ironPickNum--;
        		}
        		mineMaxNum++;
        	}
        	
        } // while
        
    	// 피로도 계산
    	/* 다이아몬드 곡괭이 : 모두 -1
    	 * 철 곡괭이 : 다이아 -5
    	 * 돌 곡괭이 : 다이아 -25, 철 -5
    	 **/
    	int fiveMineCnt = 5;
    	int mineIndex = 0;
    	int diaFatigue = 1;
    	int ironFatigue = 1;
    	int stoneFatigue = 1;
    	String currentPick = "";
    	for(int i = 0; i < allMineNum; i++) {
    		
    		
    		String currentMine = minerals[i];
    		if(fiveMineCnt++ >= 4) {
    			if(mineIndex == (picks[0] + picks[1] + picks[2])) break;
    			fiveMineCnt = 0;
    			currentPick = picksOrder[mineIndex++];
    			
    			// 곡괭이에 따른 피로도
    			if(currentPick.equals("diamond")) {
    				diaFatigue = 1;
    				ironFatigue = 1;
    				stoneFatigue = 1;
    			} else if(currentPick.equals("iron")) {
    				diaFatigue = 5;
    				ironFatigue = 1;
    				stoneFatigue = 1;
    			} else {
    				diaFatigue = 25;
    				ironFatigue = 5;
    				stoneFatigue = 1;
    			}
    		}
    		
    		if(currentMine.equals("diamond")) {
    			answer += diaFatigue;
    		} else if(currentMine.equals("iron")) {
    			answer += ironFatigue;
    		} else {
    			answer += stoneFatigue;
    		}
    			
    	}
    	
        return answer;
        
    }
    
    private int getMapVal(Map<String, Map<Integer, Integer>> map, String mine) {
    	
    	return map.get(mine).entrySet().stream().max( 
        		(m1, m2) -> m2.getValue() > m1.getValue() ? -1 : 1).get().getValue();
    }
    
    private int getMapKey(Map<String, Map<Integer, Integer>> map, String mine) {
    	
    	return map.get(mine).entrySet().stream().max( 
        		(m1, m2) -> m2.getValue() > m1.getValue() ? -1 : 1).get().getKey();
    }
    
}
