import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int num = s/n;
        if(num == 0) return new int[] {-1};
        
        Arrays.fill(answer, num);
        int sum = num*n; //arr 총 합
        int i = n-1;
        //sum이 s가 될 때까지 answer배열 값 하나씩 +1
        while(sum < s) {
            answer[i] += 1;
            sum += 1;
            i -= 1;
        }
        return answer;
    }
}