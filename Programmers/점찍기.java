class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (long a = 0; a<=d; a+=k) {
            long y = (long) Math.sqrt((long)d*(long)d - a*a); //x^2+y^2<=d^2
            answer += (int) (y/k)+1; //0까지 포함해주기 위해서 +1
        }
        return answer;
    }
}