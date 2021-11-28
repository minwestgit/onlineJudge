import java.util.*;
class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        // 첫 행 초기화
        for(int i=0;i<4;i++) {
            dp[0][i] = land[0][i];
        }
        // DP
        for(int i=1;i<land.length;i++) {
            for(int j=0;j<4;j++) {
                int max = 0;
                // 이전 행에서 최댓값을 찾아서 더해줌
                for(int k=0;k<4;k++) {
                    if(j==k) continue; // 같은 열 연속 밟기 방지
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = max+land[i][j];
            }
        }
        // 마지막 행에서 최댓값 찾아줌
        for(int i=0;i<4;i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        return answer;
    }
}