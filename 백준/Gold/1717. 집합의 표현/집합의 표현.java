import java.util.*;

public class Main {
    //== 유니온 파인드 알고리즘 ==//
    public static int Find(int v, int[] unf) {
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v], unf);
    }
    
    public static void Union(int a, int b, int[] unf) {
        int fa = Find(a, unf);
        int fb = Find(b, unf);
        if(fa != fb) unf[fa] = fb;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 숫자 범위(집합 개수)
		int m = sc.nextInt(); // 입력 연산 개수
		int[] unf = new int[n + 1];
        
        for(int i = 1; i <= n; i++) unf[i] = i;
		
		for(int i = 0; i < m; i++) {
			
			int select = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(select == 0) {
				Union(a, b, unf);
			} else {
				int temFa = Find(a, unf);
				int temFb = Find(b, unf);
				if(temFa == temFb) System.out.println("YES");
				else System.out.println("NO");
			}
			
		}
        
    }
        
}