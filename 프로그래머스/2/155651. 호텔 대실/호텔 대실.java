import java.util.*;

class Solution {
    
    class BookTime {
		int startTime, endTime;
		
		public BookTime(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	public int solution(String[][] book_time) {
		
        int answer = 0;
        int timeLen = book_time.length;
        int[] timeArry = new int[timeLen];
        List<BookTime> bookTimeList = new LinkedList<>();
        
        for(int i = 0; i < timeLen; i++) {
        	int[] time = new int[2];
        	int[] test = new int[2];
        	
        	for(int j = 0; j < 2; j++) {
        		String[] timeStr = book_time[i][j].split(":");
        		time[0] = Integer.parseInt(timeStr[0]) * 60;
        		time[1] = Integer.parseInt(timeStr[1]);
        		test[j] = time[0] + time[1];
        	}
        	
        	bookTimeList.add(new BookTime(test[0], test[1] + 10));
        }
        
        // 시작 시간 기준 오름차순 정렬
        Collections.sort(bookTimeList, ( (o1, o2) -> (o1.startTime - o2.startTime)));
        
        // 종료 시간 기준 오름차순 저장
        PriorityQueue<BookTime> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.endTime));
        
        for(BookTime book : bookTimeList) {
        	
        	if(pq.isEmpty()) {
        		pq.add(book);
        	} else {
        		BookTime tep = pq.peek();
        		
        		if(book.startTime >= tep.endTime) {
        			pq.poll();
        		}
        		pq.add(book);
        	}
            
        }
        
        answer = pq.size();
        return answer;
        
    }
}