class 124나라의숫자 {
    public String solution(int n) {
        String answer = "";
        while(n != 0) {
            int rem = n%3;
            n /= 3;
            if(rem == 0) {
                answer = 4 + answer;
                n -= 1;
            }
            else
                answer = Integer.toString(rem) + answer;
        }
        return answer;
    }
}