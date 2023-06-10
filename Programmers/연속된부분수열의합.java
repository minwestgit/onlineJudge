import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int len = Integer.MAX_VALUE;
        while(right < sequence.length && left <= right) {
            if(sum == k) {
                //길이가 짧은 수열이면 정답 update
                if(len > right-left) {
                    len = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                // left = right면 길이가 가장 짧은 수열이므로 종료
                if (left == right) {
                    break;
                }

                //left or right 이동시켜서 다음 부분 수열 찾기
                sum -= sequence[left];
                left += 1;
            }
            else if(sum < k) {
                right += 1;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            }
            else {
                sum -= sequence[left];
                left += 1;
            }
        }
        
        
        return answer;
    }
}