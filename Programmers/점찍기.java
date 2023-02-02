class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (long a = 0; a <= d/k; a++) {
            long x = a*k;
            long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2));

            answer += (y/k)+1;
        }
        return answer;
    }
}
