import java.io.IOException;

import java.util.*;

public class Main {
	
	static int locCNT = 0;
	static boolean[] visitArry; 
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int suBinLoc = sc.nextInt(); // 수빈 위치
        int brotherLoc = sc.nextInt(); // 동생 위치
        
        if(suBinLoc > brotherLoc) {
        	System.out.println((suBinLoc - brotherLoc));
        } else {
        	int[] locArry = new int[(brotherLoc * 2) + 2];
        	visitArry = new boolean[(brotherLoc * 2) + 2];
        	Logic(suBinLoc, brotherLoc, locArry);
        }
        
	} // main
	
	public static void Logic(int suBinLoc, int brotherLoc, int[] locArry) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(suBinLoc); // 처음 방문 위치 큐에 추가
		visitArry[suBinLoc] = true; // 첫 방문 표시
		
		// 수빈의 위치가 동생의 위치와 같을 때까지 반복
		while(suBinLoc != brotherLoc) {
			
			int queueSize = queue.size();
			
			for(int j=0; j<queueSize; j++) {
				
				int node = queue.poll();
				int nodeMinus = node;
				int prevNum = locArry[node];
				
				if(nodeMinus <= 0) {
					nodeMinus = 1;
				}
				
				if(node == brotherLoc) {
					suBinLoc = node;
					break;
				}
				
				// x-1 / x+1 / x*2
				// (X * 2) : 방문 기록이 없다면
				if((node * 2) <= (brotherLoc * 2) && visitArry[node * 2] != true) {
					locArry[node * 2] = prevNum;
					visitArry[node * 2] = true; // 방문 표시
					queue.add(node * 2);
					// 새로운 플래그 추가
				}
                
                // (X - 1) : 방문 기록이 없다면
				if((nodeMinus - 1) <= (brotherLoc * 2) && visitArry[nodeMinus - 1] != true) {
					locArry[nodeMinus - 1] = prevNum + 1; // 초 증가
					visitArry[nodeMinus - 1] = true; // 방문 표시
					queue.add(nodeMinus - 1); // 다음 탐색을 위해 큐에 저장
				}
                
		    	// (X + 1) : 방문 기록이 없다면
	    		if((node + 1) <= (brotherLoc * 2) && visitArry[node + 1] != true) {
		    		locArry[node + 1] = prevNum + 1;
		    		visitArry[node + 1] = true; // 방문 표시
		    		queue.add(node + 1);
		    	}
                
			} // for

			
		} // while
		System.out.println(locArry[suBinLoc]);
	}
		
} // Main