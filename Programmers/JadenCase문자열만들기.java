import java.util.*;
class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        String[] sList = s.split("");
        answer += sList[0].toUpperCase();
        for(int i=1;i<sList.length;i++) {
            answer += sList[i-1].equals(" ") ? sList[i].toUpperCase() : sList[i].toLowerCase();
        }
        
        return answer;
    }
}