import java.util.*;

class n진수게임 {
    public String[] alp = {"A", "B", "C", "D", "E", "F"};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String s = "0"; // 숫자 0부터 시작
        int num = 0;
        // 튜브가 말해야하는 마지막 숫자까지 구해줌
        while(s.length() < (t*m+p)) {
            int tmp = num++;
            String revNum = ""; // n진수를 구하기 위한 변수
            while(tmp != 0) {
                // 나머지가 10이상이면 A~F로 변환
                if(tmp%n >= 10)
                    revNum += alp[tmp%n-10];
                else 
                    revNum += Integer.toString(tmp%n);
                tmp /= n;
            }
            s += new StringBuffer(revNum).reverse().toString(); // 구한 수를 역출력해야 N진수로 변환됨 
        }
        for(int i=0;i<t;i++) {
            // 튜브가 말해야하는 숫자를 찾아 char -> String으로 변환
            answer += String.valueOf(s.charAt(p+m*i-1));
        }
        return answer;
    }
}