import java.util.*;
class 짝지어제거하기
{
    public int solution(String s)
    {
        int answer = -1;
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<str.length;i++) {
            if(stack.isEmpty())
                stack.push(str[i]);
            else if(stack.peek().equals(str[i]))
                stack.pop();
            else
                stack.push(str[i]);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}