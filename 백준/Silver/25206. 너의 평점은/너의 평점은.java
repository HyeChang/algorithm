import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> stringCompare = new ArrayList<>();
		ArrayList<String> creditAry = new ArrayList<>();
		creditAry.add("1.0");
		creditAry.add("2.0");
		creditAry.add("3.0");
		creditAry.add("4.0");
		Map<String, Double> creditLevelMap = new HashMap<>();
		creditLevelMap.put("A+", 4.5);
		creditLevelMap.put("A0", 4.0);
		creditLevelMap.put("B+", 3.5);
		creditLevelMap.put("B0", 3.0);
		creditLevelMap.put("C+", 2.5);
		creditLevelMap.put("C0", 2.0);
		creditLevelMap.put("D+", 1.5);
		creditLevelMap.put("D0", 1.0);
		creditLevelMap.put("F", 0.0);
		
		double creditLevel = 0.0;
		double majorsSubject = 0.0;
		double subjectAvg = 0.0;
		double allCredit = 0.0;
		boolean passFlag = false;
		for( int i=0; i<20; i++ ) {
			
			String[] input = br.readLine().split(" ");

			String subjectName = input[0];
			int subjectNamelen = subjectName.length();
			// 문자열 길이 체크
			if( subjectNamelen < 1 || subjectNamelen > 50 ) {
				System.out.println("문자열 길이를 확인해주세요.(1<=과목명 길이<=50)");
				return;
			}
			// 문자열 검사
			for( int j=0; j<subjectNamelen; j++ ) {
				
				char ca = subjectName.charAt(j);
				if( ca <= 0x2F || ca >= 0x3A && ca <= 0x40 || ca >= 0x5B && ca <= 0x60 || ca >= 0x7B ) {
					System.out.println("영어 또는 숫자만 입력해주세요.");
					return;
				}
				
			}
			// 중복 검사
			if( stringCompare.contains(subjectName) ) {
				System.out.println("중복된 이름을 입력하셨습니다.");
				return;
			} else {
				stringCompare.add(subjectName);
			}
			
			double credit = Double.parseDouble(input[1]);
			// 학점 입력 체크
			if( !creditAry.contains(String.valueOf(input[1])) ) {
				System.out.println("1.0|2.0|3.0|4.0 중 입력 해주세요.");
				return;
			}
			
			String creditLevelString = input[2];
			// 등급 체크
			if( !creditLevelMap.containsKey(creditLevelString) && !creditLevelString.equals("P") ) {
				System.out.println("등급에 맞게 입력해주세요.");
				return;
			}
			
			if( creditLevelMap.get(creditLevelString) != null ) {
				creditLevel = creditLevelMap.get(creditLevelString);
				majorsSubject = creditLevel * credit;
				subjectAvg += majorsSubject;
				allCredit += credit;
				passFlag = true;
			}
			
		}
		// Pass Check
		if( passFlag == false ) {
			System.out.println("한 과목은 등급이 P가 아니여야 합니다.");
			return;
		}
		
		subjectAvg = subjectAvg / allCredit;
		String subjectAvgStr = String.format("%.6f", subjectAvg);
		System.out.println(subjectAvgStr);
		
		br.close();
	}
	
}