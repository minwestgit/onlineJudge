import java.util.*;
public class 모의고사 {
    public int[] solution(int[] answers) {
        int[][] ans = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] score = {0,0,0};
        
        // 점수 구하기
        for(int i=0;i<answers.length;i++) {
            if(ans[0][i%5] == answers[i]) score[0]++;
            if(ans[1][i%8] == answers[i]) score[1]++;
            if(ans[2][i%10] == answers[i]) score[2]++;
        }

        // 최대 점수 구하기
        int max = 0;
        for(int i=0;i<3;i++) {
            if(max < score[i]) max = score[i];
        }

        // 최대 점수만큼 맞춘 사람 list에 추가
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++) {
            if(max == score[i]) list.add(i+1);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
