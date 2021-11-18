class 피보나치수 {
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return Fibonacci(n-1)%1234567 + Fibonacci(n-2)%1234567;
    }
    public int solution(int n) {
        int answer = Fibonacci(n);
        return answer;
    }
}