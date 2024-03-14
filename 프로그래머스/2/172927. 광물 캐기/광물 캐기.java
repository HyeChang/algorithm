import java.util.*;

class Solution {
    
    private class Minerals {
		int dia, iron, stone;
		
		public Minerals(int dia, int iron, int stone) {
			this.dia = dia;
			this.iron = iron;
			this.stone = stone;
		}
	}
    
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;

        int[][] scoreList = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        List<Minerals> mineralsList = new ArrayList<>();
        int totalPicksNum = Arrays.stream(picks).sum();
        
        for(int i = 0; i < minerals.length; i += 5) {
        	
        	// 곡괭이 모두 소모시 종료
        	if(totalPicksNum <= 0) break;
        	
        	int dia = 0;
        	int iron = 0;
        	int stone = 0;
        	for(int j = i; j < i + 5; j++) {
        		
        		// 모든 광물 채광 시 종료
        		if(j == minerals.length) break;
        		
        		String mineral = minerals[j];
        		int scoreVal = 0;
        		
        		// 광물 스코어 계산
        		if(mineral.equals("iron")) {
        			scoreVal = 1;
        		} else if(mineral.equals("stone")) {
        			scoreVal = 2;
        		}
        		// 각 곡괭이 마다 스코어 계산
        		dia += scoreList[0][scoreVal];
        		iron += scoreList[1][scoreVal];
        		stone += scoreList[2][scoreVal];
        		
        	} // for(j)
        	
        	// 5개 단위로 저장
        	mineralsList.add(new Minerals(dia, iron, stone));
        	totalPicksNum--;
        	
        } // for(i)
        
        // stone 기준으로 내림차순 정렬(오래 걸리는 곡괭이 기준 광물 우선 처리)
        Collections.sort(mineralsList, ( (o1, o2) -> (o2.stone - o1.stone) ));
        
        // 피로도 계산
        for(Minerals mine : mineralsList) {
        	
        	int dia = mine.dia;
        	int iron = mine.iron;
        	int stone = mine.stone;
        	
        	// 다이아 곡괭이
        	if(picks[0] > 0) {
        		answer += dia;
        		picks[0]--;
        		continue;
        	}
        	// 철 곡괭이
        	if(picks[1] > 0) {
        		answer += iron;
        		picks[1]--;
        		continue;
        	}
        	// 돌 곡괭이
        	if(picks[2] > 0) {
        		answer += stone;
        		picks[2]--;
        		continue;
        	}
        	
        }
        
        return answer;
        
    }
    
}