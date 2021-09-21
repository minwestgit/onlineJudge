import java.util.*;
class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase(); // 1단계
        answer = answer.replaceAll("[^0-9a-z-_.]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", ""); // 4단계
        if(answer.equals("")) answer = "a"; // 5단계
        
        // 6단계
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        answer = answer.replaceAll("[.]$", "");
        
        // 7단계
        if(answer.length() <= 2) {
            char tmp = answer.charAt(answer.length()-1);
            while(answer.length() < 3) {
                answer += tmp;
            }
        }
        
        return answer;
    }
}