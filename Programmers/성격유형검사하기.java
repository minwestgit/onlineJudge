import java.util.*;
class Solution {
    public static char[] type = {'R','T','C','F','J','M','A','N'}; //사전순으로 넣어둠
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        //점수 계산
        for(int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int score = choices[i] - 4; //선택지-4가 점수가 됨(+/-에 따라서 어떤 유형인지만 달라짐)
            if(score >= 0) map.put(b, map.getOrDefault(b, 0) + score);
            else map.put(a, map.getOrDefault(a, 0) + Math.abs(score));
        }
        
        //유형 결과 만들기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < type.length-1; i+=2) {
            int score1 = map.getOrDefault(type[i], 0);
            int score2 = map.getOrDefault(type[i+1], 0);
            if(score1 >= score2) sb.append(type[i]); //같아도 사전순으로 앞의 값이 결과
            else sb.append(type[i+1]);
        }
        
        return sb.toString();
    }
}