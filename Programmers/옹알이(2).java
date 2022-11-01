import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> list = Arrays.asList("aya", "ye", "woo", "ma");
        for(String ba : babbling) {
            String tmp = "";
            while(true) {
                int idx = 10;
                for(int i = 0; i < list.size(); i++) {
                    if(ba.startsWith(list.get(i)) && !tmp.equals(list.get(i))) {
                        idx = i;
                        tmp = list.get(i);
                        break;
                    }
                }
                
                if(idx == 10) break;
                else ba = ba.substring(list.get(idx).length(), ba.length()); //발음 성공하면 그 문자 pass
                
                //문자열 끝까지 체크하면 종료
                if("".equals(ba)) {
                    answer += 1;
                    break;
                }
                
            }

        }
        return answer;
    }
}