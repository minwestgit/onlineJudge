import java.util.*;
class Solution {
    public int solution(int K, int[] A) {
        int answer = A.length;
        int min = 0, max = 0;
        for(int i = 0;i < A.length; i++) {
            min = A[i];
            max = A[i];
            for(int j = i+1; j < A.length; j++) {
                max = Math.max(A[j], max);
                min = Math.min(A[j], min);
                if(max - min <= K) {
                    answer += 1;
                }
                else {
                    break;
                }
            }
        }


        return answer;
    }
}
