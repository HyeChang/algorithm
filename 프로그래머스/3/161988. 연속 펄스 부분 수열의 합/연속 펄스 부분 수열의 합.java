import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        long answer = 0;
        
        int sequenceLen = sequence.length;
        long[] maxSumP  = new long[sequenceLen];
        long[] maxSumM  = new long[sequenceLen];
        long[] plusPulseArry  = new long[sequenceLen];
        long[] minusPulseArry  = new long[sequenceLen];
        
        // 각 배열에 펄스 값 미리 계산
        int plusPulse = -1;
        int minusPulse = 1;
        for(int i = 0; i < sequenceLen; i++) {
        	plusPulse *= -1;
        	minusPulse *= -1;
        	plusPulseArry[i] = sequence[i] * plusPulse;
        	minusPulseArry[i] = sequence[i] * minusPulse;
        }
        
        maxSumP[0] = plusPulseArry[0];
        maxSumM[0] = minusPulseArry[0];
        long max = Math.max(maxSumP[0], maxSumM[0]);
        for(int i = 1; i < sequenceLen; i++) {
        	maxSumP[i] = Math.max(maxSumP[i - 1] + plusPulseArry[i], plusPulseArry[i]);
        	maxSumM[i] = Math.max(maxSumM[i - 1] + minusPulseArry[i], minusPulseArry[i]);
            max = Math.max(maxSumP[i], max);
            max = Math.max(maxSumM[i], max);
        }
        
        answer = max;
        return answer;
        
    }
}