import java.util.*;
class 배달_플로이드워셜 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N+1][N+1];
        // 최댓값으로 초기화
        for(int i=0;i<=N;i++) {
            Arrays.fill(graph[i], 500001);
        }
        // 자기 자신으로 가는 시간은 0
        for(int i=1;i<=N;i++) {
            graph[i][i] = 0;
        }
        
        for(int i=0;i<road.length;i++) {
            // 연결 도로가 여러개인 경우 최솟값으로
            if(graph[road[i][0]][road[i][1]] > road[i][2]) {
                graph[road[i][0]][road[i][1]] = road[i][2];
                graph[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        
        // 플로이드워셜 알고리즘
        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        
        for(int i=1;i<=N;i++) {
            if(graph[1][i] <= K) answer+=1;
        }
 
        return answer;
    }
}