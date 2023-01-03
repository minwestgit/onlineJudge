class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int num = storey % 10;
            //num이 5보다 크거나, 5이면서 num의 앞자리 수가 5보다 크다면 올라감
            if(num > 5 || (num == 5 && storey/10%10 >= 5)) {
                answer += 10-num;
                storey += 10-num;
            }
            else {
                answer += num;
                storey -= num;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}