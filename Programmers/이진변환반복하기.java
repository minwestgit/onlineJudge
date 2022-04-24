import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int binCnt = 0, zeroCnt = 0;
        
        while(true) {
            if("1".equals(s)) break;
            
            String str = "";
            // x의 모든 0 제거
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') str += s.charAt(i); // 1이면 남기고
                else zeroCnt += 1; // 0이면 cnt += 1
            }
            s = str;
            
            s = Integer.toBinaryString(s.length()); // x의 길이를 2진법으로
            binCnt += 1;
        }
        answer[0] = binCnt; answer[1] = zeroCnt;
        return answer;
    }
}