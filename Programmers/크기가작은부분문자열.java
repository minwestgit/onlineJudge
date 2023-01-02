import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long pp = Long.parseLong(p);
        String[] tarr = t.split("");
        for(int i = 0; i <= t.length()-len; i++) {
            String tmp = t.substring(i, i+len);
            if(pp >= Long.parseLong(tmp)) answer += 1;
        }
        
        return answer;
    }
}