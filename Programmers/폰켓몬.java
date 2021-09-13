import java.util.*;
public class 폰켓몬 {
    public int solution(int[] nums) {
        int n = nums.length/2;
        HashSet<Integer> num = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            num.add(nums[i]);
        }
        int m = num.size();
        if(n < m) return n;
        return m;
    }
}
