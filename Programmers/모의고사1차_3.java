import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int i = 1; int idx = 0;
        while(idx < order.length) {
            if(order[idx] == i) {
                answer += 1;
                i += 1;
                idx += 1;
            }
            else if(order[idx] != i) {
                if(!s.empty() && s.peek() == order[idx]) {
                    s.pop();
                    answer += 1;
                    idx += 1;
                }
                else {
                    s.push(i);
                    i += 1;
                }
            }
            if(i > order.length+1) break;
        }

        return answer;
    }
}