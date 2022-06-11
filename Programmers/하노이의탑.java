import java.util.*;

class Move {
    int start;
    int end;
    
    public Move(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static List<Move> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;
        }
        return answer;
    }
    
    public void hanoi(int n, int left, int mid, int right) {
        
        if(n == 1) {
            list.add(new Move(left, right));
            return;
        }
        
        hanoi(n-1, left, right, mid); // n-1개의 원판을 1->2로 옮김
        list.add(new Move(left, right)); // n번 원판을 1->3으로 옮김
        hanoi(n-1, mid, left, right); // n-1개의 원판을 2->3으로 옮김
    }
}
