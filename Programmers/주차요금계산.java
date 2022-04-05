import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> ansmap = new HashMap<>(); // 누적시간용 Map
        Map<String, Integer> map = new HashMap<>(); // 입,출차 관리용 Map
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            // 입차
            if("IN".equals(record[2])) {
                int intime = Integer.parseInt(record[0].substring(0,2))*60 + Integer.parseInt(record[0].substring(3,5)); // 입차 시간을 분 단위로 변환
                map.put(record[1], intime);
            }
            // 출차
            else {
                int outtime = Integer.parseInt(record[0].substring(0,2))*60 + Integer.parseInt(record[0].substring(3,5));
                int deftime = outtime - map.get(record[1]);
                // 이미 출차된 적 있던 차라면 기존 시간에 누적
                if(ansmap.containsKey(record[1])) {
                    int sumtime = ansmap.get(record[1]) + deftime;
                    ansmap.remove(record[1]);
                    ansmap.put(record[1], sumtime);
                }
                // 처음 출차되는 것이라면 ansmap에 put
                else {
                    ansmap.put(record[1], deftime);
                }
                map.remove(record[1]);
            }
        }
        
        // 출차 안한 차량 처리
        if(!map.isEmpty()) {
            for(String key : map.keySet()) {
                int deftime = (23*60+59) - map.get(key);
                if(ansmap.containsKey(key)) {
                    int sumtime = ansmap.get(key) + deftime;
                    ansmap.remove(key);
                    ansmap.put(key, sumtime);
                }
                else {
                    ansmap.put(key, deftime);
                }
            }
        }
        
        Map<String, Integer> sortedMap = new TreeMap<>(ansmap); // 차량 번호 작은 자동차순으로 정렬
        int[] answer = new int[ansmap.size()];
        int idx = 0;
        for(String key : sortedMap.keySet()) {
            int acctime = sortedMap.get(key);
            // 누적 주차 시간이 기본 시간을 초과하는 경우
            if(acctime > fees[0]) {
                int sum = fees[1];
                sum += (acctime-fees[0])%fees[2] == 0 ? (acctime - fees[0])/fees[2]*fees[3] : ((acctime - fees[0])/fees[2]+1) * fees[3];
                answer[idx++] = sum;
            }
            // 초과하지 않는 경우 기본 요금만 청구
            else {
                answer[idx++] = fees[1];
            }
        }
        
        return answer;
    }
}