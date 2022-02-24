import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> q = new LinkedList<>();
        while(true) {
            answer += 1;
            if(q.size() == bridge_length) {
                sum -= q.poll();
            }
            if(sum + truck_weights[i] <= weight) {
                if(i == truck_weights.length-1) {
                    return answer+bridge_length;
                }
                q.add(truck_weights[i]);
                sum += truck_weights[i];
                i++;
            }
            else {
                q.add(0);
            }
        }
    }
}