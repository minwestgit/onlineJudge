import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char n = s.charAt(i);
            for(int j = 1; j <= index; j++) {
                n += 1;
                if(n > 'z') n -= 26;
                if(skip.contains(String.valueOf(n))) j -= 1;
            }
            answer += String.valueOf(n);
        }
        return answer;
    }
}