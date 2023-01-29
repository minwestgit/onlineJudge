import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++) {
            if(stack.isEmpty() || numbers[i] < numbers[stack.peek()]) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        
        return answer;
    }
}