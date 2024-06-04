import java.util.*;

class Solution {
    public int solution(int[] order) {
               
        int answer = 0;
        int orderLen = order.length;
        Stack<Integer> orderStack = new Stack<>();
        
        // 택배 상자 개수 만큼 돌아가면 확인(1 ~ n)
        int orderCur = 0;
        int boxCur = 1;
        while(orderCur < orderLen) {
            
            if(order[orderCur] != boxCur) {
                
                if(orderStack.isEmpty()) {
                    orderStack.push(boxCur++);
                } else {
                    int temStVal = orderStack.peek();
                    
                    if(order[orderCur] == boxCur) {
                        boxCur++;
                        answer++;
                        orderCur++;
                    } else {
                        
                        if(order[orderCur] == temStVal) {
                            orderStack.pop();
                            answer++;
                            orderCur++;
                        } else {
                            orderStack.push(boxCur++);
                            
                            if(boxCur <= orderLen) {
                                
                                if(order[orderCur] != boxCur) {
                                    orderStack.push(boxCur++);
                                } else {
                                    answer++;
                                    boxCur++;
                                    orderCur++;
                                }
                            } else {
                                return answer;
                            }
                        }
                    }
                }
                
            } else {
                answer++;
                boxCur++;
                orderCur++;
            }
            
        }
        
        return answer;
        
    }
}