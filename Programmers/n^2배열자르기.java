import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        for(long i = left; i <= right; i++) {
            // 행 : i/n, 열 : i%n
            // n이 3일때 index가 7이라면 행은 7/3=2, 열은 7%3=1이므로 (2,1)이 된다.
            // 행, 열 중 큰 수+1이 채워질 숫자가 된다.
            // 행, 열은 0부터 시작이지만 채울 숫자는 1부터 시작이므로 +1 해줘야 한다.
            // ex) (1,2), (2,2), (2,1)에 채워질 수는 모두 2+1=3이다.
            answer[(int)i-(int)left] = Math.max((int)(i/n), (int)(i%n)) + 1;
        }
        
        return answer;
    }
}