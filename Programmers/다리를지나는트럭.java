import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int truck : truck_weights) {
            while(true) { // 트럭 올릴 때 까지 반복
                answer += 1;
                // 큐가 비어있으면 다리에 트럭 올림.
                if(q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    break;
                }
                // 다리에 트럭이 최대로 올라가면 큐에서 제거
                if(q.size() == bridge_length) {
                    sum -= q.poll();
                }
                // 다리에 트럭 더 올릴 수 있으면 큐에 추가
                if(sum + truck <= weight) {
                    q.add(truck);
                    sum += truck;
                    break;
                }
                // 못 올리면 0 추가
                else {
                    q.add(0);
                }
            }
        }
        
        return answer + bridge_length;
    }
}