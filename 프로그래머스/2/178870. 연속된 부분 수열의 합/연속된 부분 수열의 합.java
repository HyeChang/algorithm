import java.util.*;

class Solution {
    
    private class Result {
		int start, end, length;
		
		public Result(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}
		
	}
    
    public int[] solution(int[] sequence, int k) {
        
        int sequenceLen = sequence.length;
        int[] answer = new int[2];
        int startPoint = 0;
        int endPoint = 0;
        
        List<Result> resultList = new ArrayList<>();
        
        int addNum = sequence[0];
        while(startPoint < sequenceLen && endPoint < sequenceLen) {
        	
        	// 부분합이 k와 같다면
        	if(addNum == k) {
        		
        		int pointCNT = endPoint - startPoint;
        		resultList.add(new Result(startPoint, endPoint, pointCNT));
        		
        		if(startPoint == endPoint) {
        			endPoint++;
        			if(endPoint == sequenceLen) continue;
        			addNum += sequence[endPoint];
        		} else {
        			addNum -= sequence[startPoint];
        			startPoint++;
        		}
                
        	// 부분합이 k보다 작다면	
        	} else if(addNum < k) {
        		endPoint++;
        		if(endPoint == sequenceLen) continue;
        		addNum += sequence[endPoint];
        	// 부분합이 k보다 크다면 
        	} else if(addNum > k) {
        		addNum -= sequence[startPoint];
        		startPoint++;
        	}
        	
        } // while
        
    	// 결과 중 길이를 기준으로 오름차순 정렬
    	Collections.sort(resultList, ( (o1, o2) -> (o1.length - o2.length) ));
    	
    	answer[0] = resultList.get(0).start;
    	answer[1] = resultList.get(0).end;
        return answer;
        
    }
}