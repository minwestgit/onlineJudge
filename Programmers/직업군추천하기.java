import java.util.*;
class 직업군추천하기 {
    public String solution(String[] table, String[] languages, int[] preference){
        String answer = "";
        int maxScore = 0;
        for(String t : table) {
            String[] s = t.split(" ");
            int score = 0;
            for(int j=0;j<languages.length;j++) {
                int idx = Arrays.asList(s).indexOf(languages[j]);
                if(idx >= 0) score += preference[j] * (6-idx);
            }
            if(score > maxScore) {
                maxScore = score;
                answer = s[0];
            }
            else if(score == maxScore && answer.compareTo(s[0])>0) {
                answer = s[0];
            }
        }
        return answer; 
    }
}