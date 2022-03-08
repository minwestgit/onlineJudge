import java.util.*;
class Solution {
    public int solution(int K, int[] C, int[] D) {
        int answer = 0;
        Arrays.sort(C);
        Arrays.sort(D); // binarySearch하기 위해 정렬

        for(int i = 0; i < C.length; i++) {
        	// 깨끗한 양말끼리 챙겨갈 수 있는 경우
            if(i != C.length-1 && C[i] == C[i+1]) {
                i += 1; // i+1도 이미 비교한 셈이므로 +1
                answer += 1;
            }
            // Clean + Dirty 가능한지 체크
            else {
                int idx = Arrays.binarySearch(D, C[i]);
                // Dirty에 해당 번호의 양말(Clean)이 존재하면 챙김
                if(idx >= 0 && K > 0) {
                    K -= 1;
                    answer += 1;
                    D[idx] = 0; // 다시 못 빨게 0으로 바꿔줌
                }
            } 
        }
        
        Arrays.sort(D); // 더러운 양말끼리 묶기 위해 정렬
        
        // 세탁 가능한 양말이 아직 남아있다면 더러운 양말끼리 세탁해 챙길 수 있는지 체크
        for (int i = 0; i < D.length-1; i++) {
        	// 세탁 가능한 양말이 2개 미만으로 남아있다면 break
            if(K < 2){
				break;
			}
            // 더러운 양말 1쌍이 존재한다면
            if(D[i] == D[i+1] && D[i] != 0){
				answer += 1;
				K -= 2;
				i += 1;
            }

		}
        return answer;
    }   
}  