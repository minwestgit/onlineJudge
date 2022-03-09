import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 중요도 높은 순서대로 pq에 저장
        for(int priority : priorities) {
            pq.add(priority);
        }
        
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                // '현재 중요도가 가장 높은 문서 = 대기목록 i번째 문서'라면 인쇄
                if(pq.peek() == priorities[i]) {
                    if(i == location) {
                        return answer+1;
                    }
                    answer += 1;
                    pq.poll();
                }
            }
        }
        
        return answer;
    }
}