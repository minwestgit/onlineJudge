import java.util.*;
class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            // 가격이 떨어지는 순간 pop
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // 스택에 남아 있는 값 = 끝까지 가격이 떨어지지 않은 주식
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1; // 안 떨어지고 버틴 시간 계산
            stack.pop();
        }

        return answer;
    }
}