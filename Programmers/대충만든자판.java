import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();
        
        for(String keym : keymap) {
            String[] keys = keym.split("");
            int idx = 1;
            for(String key : keys) {
                //처음 나오는 문자 or 이미 나온 문자이지만 더 순서가 앞이면 put
                if(!map.containsKey(key) || idx < map.get(key)) map.put(key, idx);
                idx += 1;
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            int cnt = 0;
            String[] targetStr = targets[i].split("");
            for(String target : targetStr) {
                if(!map.containsKey(target)) { //목표 문자가 존재하지 않으면 -1
                    cnt = -1;
                    break;
                } else {
                    cnt += map.get(target);
                }
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}