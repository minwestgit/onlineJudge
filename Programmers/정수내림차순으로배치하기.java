import java.util.*;
public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        long answer = 0;
        List<Long> nums = new ArrayList<>();
        // 각 자릿수를 list에 add
        while(n!=0) {
            nums.add(n%10);
            n /= 10;
        }
        // 정렬후 역순으로 더해줌
        Collections.sort(nums);
        long tmp = 1;
        for(long num : nums) {
            answer += num*tmp;
            tmp *= 10;
        }
        
        return answer;
    } 
}
