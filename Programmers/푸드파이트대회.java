import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i]/2; j++)
                answer.append(Integer.toString(i));
        }
        StringBuilder sb = new StringBuilder(answer);
        String rev = sb.reverse().toString();
        
        return answer.toString() + "0" + rev;
    }
}