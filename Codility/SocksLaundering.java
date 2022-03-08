import java.util.*;
class Solution {
    public int solution(int K, int[] C, int[] D) {
        // write your code in Java SE 8
        int answer = 0;
        int[] clean = new int[51];
        int[] dirty = new int[51];

        // 깨끗한 양말 번호별로 count해 저장
        for(int c : C) {
            clean[c] += 1;
        }
        // 더러운 양말 번호별로 count해 저장
        for(int d : D) {
            dirty[d] += 1;
        }

        for(int i = 1; i < 51; i++) {
            answer += clean[i]/2; // 깨끗한 양말끼리 가능한 쌍 계산
            // 깨끗한 양말 + 더러운 양말 조합 계산
            if(clean[i]%2 != 0 && K > 0 && dirty[i] > 0) {
                answer += 1;
                K -= 1;
                dirty[i] -= 1;
            }
        }

        // 세탁 가능한 양말이 아직 남아있다면 더러운 양말 2개씩 묶어 처리
        for(int i = 1; i < 51; i++) {
            if(K < 2) break; // 세탁가능한 양말 개수가 2개 이상 남아있지 않다면 break
            // i번 더러운 양말이 2개 이상 남아있으면 세탁
            if(dirty[i] >= 2) {
                // i번 양말 쌍보다 세탁 가능한 양말 개수 K 중 더 작은 수 만큼만 세탁 가능
                int wash = Math.min(dirty[i], K)/2;
                answer += wash;
                K -= 2*wash;
            }
        }

        return answer;
    }
}