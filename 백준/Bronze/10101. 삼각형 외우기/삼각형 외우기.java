import java.io.IOException;

import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int AB = (A == B) ? 1 : 0;
		int AC = (A == C) ? 1 : 0;
		int BC = (B == C) ? 1 : 0;
		int abcSum = AB + AC + BC;
		
		int sum = A + B + C;
		int ABC = (A == 60 && B == 60 && C == 60) ? 60 : 0;
		
		if(ABC == 60) {
			System.out.println("Equilateral");
		} else if(sum != 180) {
			System.out.println("Error");
		} else if(abcSum == 0) {
			System.out.println("Scalene");
		} else if(abcSum == 1) {
			System.out.println("Isosceles");
		}
		
	} // main
	
}