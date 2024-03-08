import java.util.*;

class Solution {
    
    private class CTime {
		int startTime, endTime;
		
		public CTime(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
    
    // k = 삼담 유형, n = 멘토 인원, reqs = [a = 상담 시작시간, b = 상담 요청 시간, c = 원하는 상담 유형]
    public int solution(int k, int n, int[][] reqs) {
        
        int answer = 0;
        int[] bAdd = new int[k + 1];
        int[] mentoKNum = new int[k + 1];
        
        List<List<CTime>> reqsTimeList = new ArrayList<>();
        for(int i = 0; i < k + 1; i++) {
        	reqsTimeList.add(new ArrayList<>());
        	// 멘토 각 유형별로 1명씩 배치
        	mentoKNum[i] = 1;
        }
        
        // 각 유형별 인원에 따른 시작시간, 종료시간 저장
        for(int[] req : reqs) {
        	
        	int cnslStrtTime = req[0];
        	int cnslEndTime = req[0] + req[1];
        	int cnslType = req[2];
        	
        	reqsTimeList.get(cnslType).add(new CTime(cnslStrtTime, cnslEndTime));
        	
        }
        
        
        // 유형별 멘토 인원에 따른 대기시간 구하기
        int[][] waitNumberMento = new int[k + 1][n + 1];
        for(int i = 1; i < k + 1; i++) {
        	// 유형이 없으면 pass
        	if(reqsTimeList.get(i).isEmpty()) continue;
        	
        	// 멘토 배치에 따라 줄어드는 대기시간 구하기
        	for(int j = 1; j < (n - k) + 2; j++) {
        		
        		int waitTime = mentoWaitTime(reqsTimeList.get(i), j);
        		
        		//============ DEBUG ============//
        		//System.out.println("wait Time Test : " + waitTime);
        		
        		waitNumberMento[i][j] = waitTime;
        		
        	}
        }
        
        // 멘토 배치에 따라 대기시간이 제일 많이 줄어드는 곳에 멘토 배치
        // 멘토 2번째 배치 부터 시작
    	for(int i = 1; i < (n - k) + 1; i++) {
    		int maxReduceTime = 0;
    		int tempType = 1;
    		
    		for(int j = 1; j < k + 1; j++) { // 유형
        		
        		int courrentMentoCnt = mentoKNum[j];
        		
        		// 현재 상담원
        		int currentWaitTime = waitNumberMento[j][courrentMentoCnt];
        		// 상담원 + 1
        		int mentoOnePlusWaitTime = waitNumberMento[j][courrentMentoCnt + 1];
        		// 줄어드는 대기시간
        		int reduceWaitTime = currentWaitTime - mentoOnePlusWaitTime;
        		
        		if(maxReduceTime <= reduceWaitTime) {
        			maxReduceTime = reduceWaitTime;
        			tempType = j;
        		}
        			
        		// 마지막 유형이 끝났으면 종료
        		if((j + 1) >= (k + 1)) {
        			//============ DEBUG ============//
        			//System.out.println("타입 테스트 : " + tempType);
        			continue;
        		}
        	}
            
    		mentoKNum[tempType] += 1;
            
        }
        
    	// 최적 배치된 인원에 따라 대기시간 계산
    	for(int i = 1; i < k + 1; i++) {
            
            // 유형이 없으면 pass
        	if(reqsTimeList.get(i).isEmpty()) continue;
            
    		answer += waitNumberMento[i][mentoKNum[i]];
            
    	}
    	
        //============ DEBUG ============//
        //System.out.println("각 유형별 배정된 맨토 인원 : " + Arrays.toString(mentoKNum));
        //System.out.println("최적 대기시간 : " + answer);
        
        return answer;
        
    } // solution
    
    // 멘토 인원에 따른 대기시간
	public int mentoWaitTime(List<CTime> reqsTimeList, int mentoNCnt) {
		
		// 종료 시간이 작을때 상담을 먼저 종료 하기 위해
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 상담 종료 시간 저장
		int waitTime = 0;
		
		for(CTime time : reqsTimeList) {
			
			// 상담원이 존재할 때
			if(pq.isEmpty() || pq.size() < mentoNCnt) {
				pq.add(time.endTime);
			} else {
				int preEndTime = pq.poll();
				
				// 대기시간이 있는 경우
				if(preEndTime > time.startTime) {
					waitTime += preEndTime - time.startTime;
					pq.add(preEndTime + (time.endTime - time.startTime));
				}
				// else 대기시간이 없는 경우
				else {
					pq.add(time.endTime);
				}
			}
			
		} // for
		
		return waitTime;
	} // mentoWaitTime
    
}