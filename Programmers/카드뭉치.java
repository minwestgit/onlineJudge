import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> card1 = new LinkedList<>();
        for(String card : cards1) {
            card1.add(card);
        }
        Queue<String> card2 = new LinkedList<>();
        for(String card : cards2) {
            card2.add(card);
        }
        
        for(String g : goal) {
            if(g.equals(card1.peek())) card1.poll();
            else if(g.equals(card2.peek())) card2.poll();
            else return "No";
        }
        
        return "Yes";
    }
}