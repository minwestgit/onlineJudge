import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(char c : s.toCharArray()) {
            for(int j = 0; j < index; j++) {
                c += 1;
                if(c > 'z') c -= 26;
                if(skip.contains(String.valueOf(c))) j -= 1;
            }
            answer += String.valueOf(c);
        }
        return answer;
    }
}