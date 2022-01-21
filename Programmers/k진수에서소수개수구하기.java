class k진수에서소수개수구하기 {
    // 소수 판별
    public boolean isPrime(long n) {
        if(n < 2) return false;
        for(long i=2;i*i<=n;i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k); // k진수로 변환
        String[] array = num.split("");
        
        String str = "";
        for(String s : array) {
            // 0을 만나면 소수인지 판별
            if(s.equals("0") && str != "") {
                long prime = Long.parseLong(str);
                if(isPrime(prime)) answer += 1;
                str = "";
            }
            else {
                str += s;
            }
        }
        // 마지막 남은 숫자 판별
        long prime = Long.parseLong(str);
        if(isPrime(prime)) answer += 1;
        return answer;
    }
}