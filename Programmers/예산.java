import java.util.*;
class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        for(int i=0;i<d.length;i++) {
            sum += d[i];
            if(sum > budget) {
                answer = i;
                break;
            }
            answer = i+1;
        }
        return answer;
    }
}