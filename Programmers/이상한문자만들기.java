import java.util.*;
class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        String[] sList = s.split("");
        
        int n = 0;

        for(String str : sList) {
            if(str.equals(" ")) {
                answer += " ";
                n = 0;
                continue;
            }
            answer += n%2==0 ? str.toUpperCase() : str.toLowerCase();
            n++;
        }
        return answer;
    }
}