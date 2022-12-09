import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        
        for(int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i)-97;
            if(alpha[index] == -1) answer[i] = -1;
            else answer[i] = i-alpha[index];
            alpha[index] = i;
        }
        
        return answer;
    }
}