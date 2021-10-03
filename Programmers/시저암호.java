import java.util.*;
class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            // 공백
            if(ch == ' ') {
                answer += ch;
                continue;
            }
            // 소문자
            if(ch >= 'a' && ch <= 'z') {
                answer += (char) ('a'+(ch+n-'a')%26);
            }
            // 대문자
            else {
                answer += (char) ('A'+(ch+n-'A')%26);
            }
        }
        return answer;
    }
}