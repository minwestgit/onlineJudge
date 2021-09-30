import java.util.*;
class 3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        String ans = "";
        while(n != 0) {
            ans += n%3;
            n /= 3;
        }
        return Integer.parseInt(ans, 3);
    }
}