import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();
        List<String> lzw = new ArrayList<>();
        // 사전 초기화
        for(char i = 'A';i <= 'Z'; i++) {
            lzw.add(Character.toString(i));
        }
        
        String[] str = msg.split("");
        for(int i = 0;i < str.length; i++) {
            String s = str[i];
            // 사전에 포함되지 않는 글자가 나올때까지 반복
            while(lzw.indexOf(s) >= 0) {
                i += 1;
                // 마지막 단어이면 break
                if(i == str.length) {
                    break;
                }
                s += str[i];
            }
            
            // 마지막 단어이면 그 단어도 ans에 포함
            if(i == str.length) {
                ans.add(lzw.indexOf(s)+1);
                break;
            }
            
            ans.add(lzw.indexOf(s.substring(0,s.length()-1))+1); // 정답에 색인 번호 추가
            lzw.add(s); // 사전 추가
            i--; // 추가된 마지막 단어부터 다시 시작해야하므로 i-=1
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0;i < ans.size() ; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}