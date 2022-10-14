import java.util.*;
class Solution {
    public static int answer = 0;
    public int solution(int[] number) {
        Arrays.sort(number);
        boolean[] visited = new boolean[number.length];
        comb(number, visited, 0, 3); //조합으로 삼총사 체크하기
        return answer;
    }

    public void comb(int[] number, boolean[] visited, int n, int r) {
        if(r == 0) {
            int sum = 0;
            for(int i = 0; i < number.length; i++) {
                if(visited[i]) sum += number[i];
            }
            if(sum == 0) answer += 1; //삼총사 성공
            return;
        }

        if(n == number.length) return; //3명으로 삼총사 못만들면 return
        visited[n] = true;
        comb(number, visited, n+1, r-1); //n번째 학생 포함하는 경우
        visited[n] = false;
        comb(number, visited, n+1, r); //n번째 학생 포함 안하는 경우
    }
}