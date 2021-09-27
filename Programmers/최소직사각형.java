import java.util.*;
public class 최소직사각형 {  
    public int solution(int[][] sizes) {
        int width = 0, height = 0;
        for (int i=0;i<sizes.length;i++) {
            // 가로길이 : 둘 중 큰 수에서 최댓값
            width = Math.max(width, Math.max(sizes[i][0], sizes[i][1]));
            // 새로길이 : 둘 중 작은 수에서 최댓값
            height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
        }
        return width*height;
    }
       
}
