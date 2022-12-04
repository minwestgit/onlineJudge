import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] strs = s.split("");
        int same = 0, dif = 0;
        String first = "";
        for(String str : strs) {
            if(same == dif) {
                answer += 1;
                same = 1;
                dif = 0;
                first = str;
                continue;
            }
            if(str.equals(first)) same += 1;
            else dif += 1;
        }
        
        return answer;
    }
}