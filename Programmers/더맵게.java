import java.util.*;
class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add(s);
        }
        // 가장 맵지 않은 음식의 스코빌 지수가 K보다 작으면 반복
        while(K > pq.peek()) {
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
            if(pq.size() < 2) {
                return -1;
            }
            int food1 = pq.poll();
            int food2 = pq.poll();
            pq.add(food1 + food2*2); // 섞기
            answer++;
        }
        return answer;
    }
}