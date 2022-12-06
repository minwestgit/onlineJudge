import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> tops = new ArrayList<>();
        for(int s : score) {
            tops.add(s);
            Collections.sort(tops, Collections.reverseOrder());
            if(tops.size() < k) ans.add(tops.get(tops.size()-1));
            else ans.add(tops.get(k-1));
        }
        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}