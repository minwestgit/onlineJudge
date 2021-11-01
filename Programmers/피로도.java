import java.util.*;
class 피로도 {
    public static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int cnt = 0;
        dfs(k, dungeons, visited, cnt);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        // 모든 던전을 탐험한 경우
        if(cnt == dungeons.length) {
            answer = cnt;
            return;
        }
        for(int i=0;i<dungeons.length;i++) {
            if(visited[i]) continue;
            // 더 이상 피로도를 소모할 수 없는 경우
            if(k<dungeons[i][0]) {
                answer = Math.max(answer, cnt);
                continue;
            }
            visited[i] = true;
            dfs(k-dungeons[i][1], dungeons, visited, cnt+1);
            visited[i] = false;
        }
    }
}