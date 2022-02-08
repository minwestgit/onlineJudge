import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0;i < numbers.length; i++) {
            // 0으로 끝나면 맨 끝만 1로 바꿔주면 되므로 +1 해주면 된다.
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            }
            // 1로 끝나는 경우
            else {
                String num = Long.toString(numbers[i], 2); // 2진수 변환
                // 중간에 0이 포함된 경우
                if(num.contains("0")) {
                    for(int j = num.length()-1;j >= 0; j--) {
                        // 가장 뒤에 있는 0을 1로, 그 바로 뒤를 0으로 변경해주면 된다.(ex. 10101 -> 10110)
                        if(num.charAt(j) == '0') {
                            num = num.substring(0, j) + "10" + num.substring(j+2, num.length());
                            break;
                        }
                    }
                }
                // 1로만 구성된 경우
                else {
                    num = "10" + num.substring(1, num.length()); // 맨 앞을 "10"으로 변경하면 된다.
                }
                answer[i] = Long.parseLong(num, 2);
            }
        }
        return answer;
    }
}