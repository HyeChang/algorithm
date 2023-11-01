import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 속도 체크
public class Main {
 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
		
		int resultWX = w - x;
		int resultHY = h - y;
		
		int resultX = 0;
		int resultY = 0;

		if(x >= resultWX) resultX = resultWX;
		if(x <= resultWX) resultX = x;
		if(y >= resultHY) resultY = resultHY;
		if(y <= resultHY) resultY = y;
		
		System.out.println( ((resultX >= resultY) ? resultY : resultX) );
		
	}
	
}