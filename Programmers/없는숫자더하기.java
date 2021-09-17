import java.util.*;
class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        for(int i=0;i<=9;i++) {
            if(Arrays.binarySearch(numbers, i) < 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}