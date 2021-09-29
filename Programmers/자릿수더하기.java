import java.util.*;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String s = n + "";
        String[] sList = new String[s.length()];
        sList = s.split("");
        for(int i=0;i<sList.length;i++) {
            answer += Integer.parseInt(sList[i]);
        }

        return answer;
    }
}
