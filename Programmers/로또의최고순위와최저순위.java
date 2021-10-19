import java.util.*;
class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(win_nums);
        int ansCnt = 0, zeroCnt = 0;
        for(int lotto : lottos) {
            if(Arrays.binarySearch(win_nums, lotto) >= 0) ansCnt++;
            if(lotto == 0) zeroCnt++;
        }
        if(ansCnt+zeroCnt == 0) answer[0] = 6;
        else answer[0] = 6-ansCnt-zeroCnt+1;
        if(ansCnt == 0) answer[1] = 6;
        else answer[1] = 6-ansCnt+1;
        return answer;
    }
}