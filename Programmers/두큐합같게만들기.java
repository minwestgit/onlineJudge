import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0; long sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        while(sum1 != sum2) {
            if(answer > 300000) return -1;
            if(sum1 < sum2) {
                int now = q2.poll();
                q1.add(now);
                sum1 += now;
                sum2 -= now;
            }
            else if(sum1 > sum2) {
                int now = q1.poll();
                q2.add(now);
                sum1 -= now;
                sum2 += now;
            }
            answer += 1;
        }
        
        return answer;
    }
}