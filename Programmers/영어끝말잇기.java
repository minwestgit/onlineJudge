import java.util.*;
class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<words.length;i++) {
            String word = words[i];
            
            // 앞사람이 말한 단어의 마지막 문자로 시작하는지
            String prevWord = list.get(i-1);
            if(prevWord.charAt(prevWord.length()-1) != word.charAt(0)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                return answer;
            }
            
            // 이전에 등장했던 단어인지 check
            if(list.contains(word)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                return answer;
            }
            
            list.add(word); // 끝말잇기 진행
            
        }
        answer[0] = answer[1] = 0; // 탈락자가 생기지 않는다면 [0,0]
        return answer;
    }
}