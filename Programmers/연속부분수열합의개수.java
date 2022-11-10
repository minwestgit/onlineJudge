import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        for(int i = 0; i < len; i++) {
            int sum = 0;
            for(int j = i; j < len+i; j++) {
                sum += j>=len ? elements[j-len] : elements[j];
                set.add(sum);
            }
        }
        return set.size();
    }
}