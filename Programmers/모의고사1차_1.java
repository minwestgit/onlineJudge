import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        StringBuilder result = new StringBuilder(); //StringBuilder가 더 빠름. String 쓰면 오답.
        String[] xx = X.split("");
        String[] yy = Y.split("");
        Arrays.sort(xx, Collections.reverseOrder()); Arrays.sort(yy, Collections.reverseOrder());
        int xi = 0, yi = 0;
        while(xi < xx.length && yi < yy.length) {
            if(xx[xi].equals(yy[yi])) {
                result.append(xx[xi]);
                xi += 1;
                yi += 1;
            }
            else {
                if(Integer.parseInt(xx[xi]) > Integer.parseInt(yy[yi])) xi += 1;
                else yi += 1;
            }
        }
        answer = result.toString();
        if(answer.equals("")) return "-1";
        if(answer.charAt(0) == '0') return "0";

        return answer;
    }
}