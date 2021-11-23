public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int start = 0, end = 0;
        int sum = 0;
        while(end<=n) {
            if(sum == n) answer++;
            if(sum<n) {
                start++;
                sum += start;
            }
            else {
                end++;
                sum -= end;
            }
        }
        return answer;
    }
}