import java.util.*;
class 상호평가 {
    public String solution(int[][] scores) {
        String answer = "";
        for(int i=0;i<scores.length;i++) {
            int sum = 0;
            int score = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<scores.length;j++) {
                list.add(scores[j][i]);
                sum += scores[j][i];
            }
            Collections.sort(list);
            // 자기 자신이 유일한 최고점인 경우
            if(scores[i][i] == list.get(scores.length-1) && scores[i][i] != list.get(scores.length-2)) {
                sum -= scores[i][i];
                score = sum/(scores.length-1);
            }
            // 자기 자신이 유일한 최저점인 경우
            else if(scores[i][i] == list.get(0) && scores[i][i] != list.get(1)) {
                sum -= scores[i][i];
                score = sum/(scores.length-1);
            }
            else {
                score = sum/scores.length;
            }
            
            // 학점 부여
            if(score >= 90) answer += "A";
            else if(score >= 80) answer += "B";
            else if(score >= 70) answer += "C";
            else if(score >= 50) answer += "D";
            else answer += "F";
        }
        return answer;
    }
}