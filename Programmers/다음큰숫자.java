import java.util.*;
class 다음큰숫자 {
    public int countOne(int n) {
        String binaryNum = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0;i<binaryNum.length();i++) {
            if(binaryNum.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
    public int solution(int n) {
        int num = n;
        int nCnt = countOne(n);
        while(true){
            int numCnt = countOne(++num);
            if(nCnt == numCnt) break;
        }
        return num;
    }
}