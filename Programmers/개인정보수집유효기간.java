import java.util.*;
class Solution {
    public static int today_year;
    public static int today_month;
    public static int today_day;
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        today_year = Integer.parseInt(today.substring(0,4));
        today_month = Integer.parseInt(today.substring(5,7));
        today_day = Integer.parseInt(today.substring(8,10));
        Map<String, String> map = new HashMap<>();
        for(String term : terms) {
            String[] info = term.split(" ");
            map.put(info[0], info[1]);
        }
        
        int i = 1;
        for(String privacy : privacies) {
            String[] pri = privacy.split(" ");
            String term_day = map.get(pri[1]);
            boolean chk = com_date(pri[0], Integer.parseInt(term_day));
            if(!chk) answer.add(i);
            i += 1;
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    public static boolean com_date(String info_date, int term_day) {
        int info_year = Integer.parseInt(info_date.substring(0,4));
        int info_month = Integer.parseInt(info_date.substring(5,7));
        int info_day = Integer.parseInt(info_date.substring(8,10)) - 1;
        //약관별 유효기간 계산
        info_year += term_day/12;
        info_month += term_day%12;
        if(info_month > 12) {
            info_month = info_month % 12;
            info_year += 1;
        }
        
        //오늘날짜와 비교해 파기여부 체크
        if(today_year > info_year) return false;
        if(today_year==info_year && today_month > info_month) return false;
        if(today_year==info_year && today_month == info_month && today_day > info_day) return false;
        
        return true;
    }
}