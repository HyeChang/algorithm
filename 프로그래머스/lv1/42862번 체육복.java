import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int lostNum = 0;
        int[] reserveCheck = new int[reserve.length];
        boolean flag = false;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌을 가진 사람이 잃어 버렸을 때
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserveCheck[j] = 1;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {

            lostNum = lost[i];

            // 여분 옷 배열 확인
            for(int j=0; j<reserve.length; j++) {

                // 여벌을 가진 사람이 잃어 버렸을 때
                if(lostNum == 0) {
                    
                    flag = true;
                    break;
                    
                } else if( (lostNum - 1) <= reserve[j] && (lostNum + 1) >= reserve[j] ) {
                    
                    if( (lostNum - 1) == reserve[j] && reserveCheck[j] == 0 ) {
                        reserveCheck[j] = 1;
                        flag = true;
                        break;
                    } else if( (lostNum + 1) == reserve[j] && reserveCheck[j] == 0 ) {
                        reserveCheck[j] = 1;
                        flag = true;
                        break;
                    }
                }
                
            }

            if(!flag) {
                answer--;
            } else {
                flag = false;
            }
            
        } // for_1
        return answer;
    }
}
