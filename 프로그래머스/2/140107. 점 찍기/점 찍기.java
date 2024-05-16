class Solution {
    public long solution(int k, int d) {
        
        long answer = 0;
        
        // 원의 1사분면에 속하는 정수 쌍 구하기
        // x에 대한 최대 Y 값 : x^2 + maxY^2 = d^2
        
        for(int i = 0; i <= d; i += k) {
            
            long maxY = (int) Math.sqrt((long)d*d - (long)i*i);
            
            // (x, 0)포함을 위하여 +1
            answer += (maxY / k) + 1;
            
        }
        
        return answer;
        
    }
}