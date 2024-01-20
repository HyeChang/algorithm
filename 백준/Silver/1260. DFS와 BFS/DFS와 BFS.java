import java.io.IOException;

import java.util.*;

public class Main {
	
	private static List<Integer>[] graph; // 연결 그래프
	private static boolean[] visitPath; // 방문 여부
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int V = sc.nextInt(); // 시작 노드
		
		/*** 그래프 생성 ***/
		graph = new List[N + 1];
		// 정점의 개수 기준 그래프 초기화
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 인접 노드 연결(양방향)
		for(int j = 0; j < M; j++) {
			// 간선 입력
			int startLine = sc.nextInt();
			int endLine = sc.nextInt();
			
			// 그래프 양방향 연걸
			graph[startLine].add(endLine);
			graph[endLine].add(startLine);
		}

		// 각 정점과 연결된 노드 오름차순 정렬
		for(int n = 1; n <= N; n++) {
			graph[n] = MergeSort.mergeSort(graph[n]);
		}
		
		/*** DFS ***/
		visitPath = new boolean[N + 1];
		DFS(V);
		System.out.println();
		
		/*** BFS ***/
		visitPath = new boolean[N + 1];
		BFS(V);
		System.out.println();
		
	} // main
	
	// 재귀
	public static void DFS(int startNode) {
		
		System.out.print(startNode + " ");
		visitPath[startNode] = true; // 방문 노드 표시
		
		for(int i : graph[startNode]) {
			// 방문 표시가 없을 때 진행
			while(!visitPath[i]) {
				DFS(i);
			}
		}
		
	}
	
	// Queue
	public static void BFS(int startNode) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode); // 방문 노드 큐에 추가
		visitPath[startNode] = true; // 방문 노드 표시
		
		// 큐에 저장된 값
		while(!queue.isEmpty()) {
			int cursorNode = queue.poll();
			System.out.print(cursorNode + " ");
			// 연결된 노드 검색
			for(int i : graph[cursorNode]) {
				if(!visitPath[i]) { // 방문 안한 노드 일 때
					queue.add(i);
					visitPath[i] = true;
				}
			}
		}
		
	}
	
}

class MergeSort {
	
	public static List<Integer> mergeSort(List<Integer> targetList) {
		
		if(targetList.size() > 1) {
			
			return merge(
					mergeSort(targetList.subList(0, targetList.size() / 2)),
					mergeSort(targetList.subList(targetList.size() / 2, targetList.size()))
					);
			
		} else {
			return targetList;
		}
		
	} // mergeSort{}
	
	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		
		// 결과 저장 용 임시 배열
		List<Integer> resultList = new ArrayList<>();
		int rightIdx = 0;
		
		// 왼쪽 리스트 순환
		for(int i : left) {
			
			// 오른쪽 리스트 순환 확인 && 왼쪽 리스트 값 과 오른쪽 리스트 값 비교(왼 > 오)
			while(right.size() > rightIdx && i > right.get(rightIdx)) {
				// 작은 값을 결과 배열에 넣는다.
				resultList.add(right.get(rightIdx));
				rightIdx++;
			}
			// 왼쪽 리스트가 작으면 왼쪽 값 저장
			resultList.add(i);
		}
		// 오른쪽 리스트의 남은 값 저장
		for(int r = rightIdx; r < right.size(); r++) {
			resultList.add(right.get(r));
		}
		return resultList;
		
	} // merge{}
	
}