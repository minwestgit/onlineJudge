import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //우선순위큐 사용해 enemy 수 가장 많을 때 무적권 사용 가능
        
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            
            //남은 병사 수가 -가 되면 무적권 사용
            if(n < 0) {
                if(k > 0) {
                    k -= 1;
                    n += pq.poll();
                }
                else break;
            }
            answer += 1;
        }

        return answer;
    }
}