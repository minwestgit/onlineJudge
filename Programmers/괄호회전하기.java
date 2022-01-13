import java.util.*;
class 괄호회전하기 {
    public boolean checkStr(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')') {
                if(stack.peek() != '(') return false;
                stack.pop(); 
            }
            else if(s.charAt(i) == '}') {
                if(stack.peek() != '{') return false; 
                stack.pop(); 
            }
            else if(s.charAt(i) == ']') {
                if(stack.peek() != '[') return false;
                stack.pop(); 
            }
            else {
                stack.push(s.charAt(i));
            }
        }
       
        return stack.isEmpty() ? true : false;

    }
    public int solution(String s) {
        int answer = 0;
       
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(0);
            s = s.substring(1, s.length()) + c;
            if(checkStr(s)) answer += 1;
        }
        return answer;
    }
}