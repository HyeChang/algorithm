import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        int answer = 0;
        PriorityQueue<Integer> resultPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        // 각 배열 내림차순 정렬
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // 최대 공약수 구하기
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        
        // 나눠지는 조건 확인
        // a -> b check
        if(!divideCheck(arrayB, gcdA)) {
            resultPQ.add(gcdA);
        }
        // b -> a check
        if(!divideCheck(arrayA, gcdB)) {
            resultPQ.add(gcdB);
        }
        
        if(resultPQ.isEmpty()) {
            return 0;
        } else {
            answer = resultPQ.poll();
            return answer;
        }
        
    }
    
    // gcd
    private int gcd(int a, int b) {
        
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
        
    }
    
    private boolean divideCheck(int[] array , int gcd) {
        
        for(int num : array) {
            if(num % gcd == 0) {
                return true;
            } 
        }
        return false;
        
    }
    
    
}