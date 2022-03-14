import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numstr = new String[numbers.length];
        
        // int -> String
        for(int i = 0; i < numbers.length; i++) {
            numstr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(numstr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2); // 내림차순
            }
        });
        
        if("0".equals(numstr[0])) return "0";
        
        for(String num : numstr) {
            answer += num;
        }
        return answer;
    }
}