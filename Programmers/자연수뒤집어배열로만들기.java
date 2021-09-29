import java.util.*;
class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {       
        ArrayList<Long> list = new ArrayList<>();
        while(n != 0) {
            list.add(n%10);
            n /= 10;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = Long.valueOf(list.get(i)).intValue();
        }
        return answer;
    }
}