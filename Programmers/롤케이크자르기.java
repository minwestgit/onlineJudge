import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> ob = new HashSet<>(); //철수
        Set<Integer> yb = new HashSet<>(); //동생
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < topping.length; i++) {
            yb.add(topping[i]);
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1); //동생 토핑 count
        }
        
        for(int i = 0; i < topping.length; i++) {
            ob.add(topping[i]);
            map.replace(topping[i], map.get(topping[i])-1);
            if(map.get(topping[i]) < 1) yb.remove(topping[i]); //특정 토핑 0개 되면 remove
            if(ob.size() == yb.size()) answer += 1;
        }
        
        
        return answer;
    }
}