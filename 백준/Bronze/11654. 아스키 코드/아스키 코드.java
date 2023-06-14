import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		char ch = sc.nextLine().charAt(0);
		int num = (int)ch;
		
		System.out.println(num);
	}
}