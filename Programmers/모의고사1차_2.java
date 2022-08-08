import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        if(check(want,number,map)) answer++;

        for(int i = 10; i < discount.length; i++){
            map.replace(discount[i-10], map.get(discount[i-10])-1); //맨 앞에거 뺴고
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1); //하나 추가해서 10일치 만듦
            if(check(want,number,map)) answer++;
        }

        return answer;
    }

    //원하는 물품 다 살 수 있는지 체크
    public static boolean check(String[] want, int[] number,Map<String,Integer> map){
        for(int i = 0; i < want.length; i++) {
            if(map.get(want[i]) == null || map.get(want[i]) < number[i]) {
                return false;
            }
        }
        return true;
    }
}