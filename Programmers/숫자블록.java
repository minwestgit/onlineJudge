public class 숫자블록 {
    public int[] solution(long begin, long end) {
        int beginInt = (int) begin;
        int endInt = (int) end;
        int[] answer = new int[endInt-beginInt+1];
        
        int idx = 0;
        for(int i = beginInt; i < endInt+1; i++) {
            answer[idx] = block(i);
            idx += 1;
        }
        
        return answer;
    }
    
    public int block(int n) {
        if(n == 1) return 0;
        
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0 && n/i <= 10000000) { //블럭은 10000000까지만 가능
                return n/i; //가장 작은 약수로 나눈 값 = 가장 큰 약수
            }
        }
        
        return 1; //소수이면 1
    }
}