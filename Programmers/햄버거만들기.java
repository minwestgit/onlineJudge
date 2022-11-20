import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int in : ingredient) {
            list.add(in);
            int len = list.size();
            if(len >= 4 && list.get(len-4) == 1
              && list.get(len-3) == 2
              && list.get(len-2) == 3
              && list.get(len-1) == 1) {
                answer += 1;
                for(int j = 0; j < 4; j++) list.remove(list.size()-1);
            }
            
        }
        return answer;
    }
}