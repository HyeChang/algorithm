import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        int plansLen = plans.length;
        String[] answer = new String[plansLen];
        
        Map<String, Date> startTimeMap = new HashMap<>();
        Map<String, Date> endTimeMap = new HashMap<>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        
        try {
        	
        	// 종료 시간 계산
        	for(int i = 0; i < plansLen; i++) {
        		
        		startTimeMap.put(plans[i][0], formatter.parse(plans[i][1]));
        		endTimeMap.put(plans[i][0], formatter.parse(plans[i][1]));
        		cal.setTime(endTimeMap.get(plans[i][0]));
        		cal.add(Calendar.MINUTE, Integer.parseInt(plans[i][2]));
        		endTimeMap.replace(plans[i][0], cal.getTime());
        		
        	}
        	
        	// 과제 시간대로 오름차순 정렬
        	List<Map.Entry<String, Date>> entries = 
        			startTimeMap.entrySet().stream()
        			.sorted(Map.Entry.comparingByValue())
        			.collect(Collectors.toList());
        	
        	int index = 0;
        	int answerCnt = 0;
        	String popStr = "";
        	Stack<String> stack = new Stack<>();
        	while(!entries.isEmpty()) {
        		
        		String key = entries.listIterator(index).next().getKey();
        		Date value = entries.listIterator(index).next().getValue();
        		Date endDate = endTimeMap.get(key);
        		Date nextValue = null;
        		
        		if(!popStr.isBlank()) {
        			key = popStr;
        			popStr = "";
        			endDate = endTimeMap.get(key);
        		}
        		
        		// 마지막일때 종료 조건
        		if(entries.isEmpty()) {
        			answer[answerCnt++] = key;
        			break;
        		} else if(entries.size() == index + 1) {
        			answer[answerCnt++] = key;
        			entries.remove(index);
        			index--;
        			continue;
        		} else {
        			nextValue = entries.listIterator(index + 1).next().getValue();
        		}
                
        		// endDate > nextValue
        		// 현재 진행 중인 과제 중간에 시작할 과제가 존재할경우
        		if(endDate.after(nextValue)) {
        			// 현재 진행 중인 과제 Stack push
        			stack.push(key);
        			popStr = "";
        			index++;
        		}

        		// endDate < nextValue && endDate == nextValue
        		// 현재 과제의 종료 시점이 다음 과제의 시작 시점보다 작으면 종료
        		if(endDate.before(nextValue) || endDate.compareTo(nextValue) == 0) {
        			answer[answerCnt++] = key;
        			entries.remove(index);
                    
        			if(!stack.isEmpty() && endDate.compareTo(nextValue) != 0) {
        				popStr = stack.pop();
        				index--;
            		}
        		}
        		
        	} // while
        	
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        
        return answer;
        
    }
}
