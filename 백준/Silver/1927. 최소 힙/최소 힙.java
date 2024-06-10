import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int numSize = sc.nextInt();
        int insertNum = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < numSize; i++) {
            
            insertNum = sc.nextInt();
            
            if(insertNum <= 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(insertNum);
            }
        }   
        
    }
    
}