import java.util.*;
class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]); // 2진수로 변경
            // 길이 n만큼 0 채워넣음
            while(str.length() < n) {
                str = "0" + str;
            }
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            answer[i] = str;
        }
        return answer;
    }
}