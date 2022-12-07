import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : score) {
            pq.add(s);
            if (pq.size() > k) {
                pq.poll();
            }
            ans.add(pq.peek());

        }
        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}