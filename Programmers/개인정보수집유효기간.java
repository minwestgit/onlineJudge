import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int today_total = Integer.parseInt(today.substring(0,4))*12*28
                        + Integer.parseInt(today.substring(5,7))*28
                        + Integer.parseInt(today.substring(8,10));
        Map<String, String> map = new HashMap<>();
        for(String term : terms) {
            String[] info = term.split(" ");
            map.put(info[0], info[1]);
        }
        
        int i = 1;
        for(String privacy : privacies) {
            String[] pri = privacy.split(" ");
            int pri_total = Integer.parseInt(pri[0].substring(0,4))*12*28
                        + Integer.parseInt(pri[0].substring(5,7))*28
                        + Integer.parseInt(pri[0].substring(8,10));
            int term_month = Integer.parseInt(map.get(pri[1]));
            if(pri_total + term_month*28 <= today_total) answer.add(i);
            i += 1;
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}