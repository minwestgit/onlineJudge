import java.util.*;
class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] sList = s.split(" ");
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=0;i<sList.length;i++) {
            nums.add(Integer.parseInt(sList[i]));
        }
        Collections.sort(nums);
        answer = Integer.toString(nums.get(0)) + " " + Integer.toString(nums.get(nums.size()-1));
        return answer;
    }
}