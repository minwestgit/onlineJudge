import java.util.*;
public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++) {
            int x = commands[i][0]-1;
            int y = commands[i][1];
            int[] temp = Arrays.copyOfRange(array,x,y);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}
