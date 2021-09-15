import java.util.*;
public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        int score[] = new int[3]; // 3번의 기회
        int index = -1;
        for(int i=0;i<dartResult.length();i++) {
            char c = dartResult.charAt(i);
            if(c == 'S') {
                score[index] = (int) Math.pow(score[index], 1);
            }
            else if(c == 'D') {
                score[index] = (int) Math.pow(score[index], 2);
            }
            else if(c == 'T') {
                score[index] = (int) Math.pow(score[index], 3);
            }
            else if(c == '*') {
                score[index] *= 2;
                if(index >= 1) score[index-1] *= 2;
            }
            else if(c == '#') {
                score[index] *= -1;
            }
            // 점수
            else {
                index++;
                char next = dartResult.charAt(i+1);
                // 10점인 경우
                if(c == '1' && next == '0') {
                    score[index] = 10;
                    i++;
                }
                else {
                    score[index] = c-'0';
                }
            }
        }
        
        for(int i=0;i<3;i++) {
            answer += score[i];
        }
        return answer;
    }
}
