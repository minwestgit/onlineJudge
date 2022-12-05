import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //크기별 갯수 map에 count
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        //value(갯수) 기준 내림차순 정렬
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        
        for(Map.Entry<Integer, Integer> entry : entryList){
            k -= entry.getValue();
            answer += 1;
            
            if(k <= 0) break; //다 수확하면 break
        }
        
        
        
        return answer;
    }
}