import java.util.*;
class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j<numbers.length;j++) {
            	// 중복 체크해서 추가
                if(list.indexOf(numbers[i]+numbers[j]) < 0) {
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}