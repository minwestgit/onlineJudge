import java.util.*;
class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        int[][] con = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        
        // 연결된 송전탑 체크
        for(int i=0;i<wires.length;i++) {
            con[wires[i][0]][wires[i][1]] = 1;
            con[wires[i][1]][wires[i][0]] = 1;
        }
        
        // 전력망 네트워크 분할
        for(int i=0;i<wires.length;i++) {
            
            con[wires[i][0]][wires[i][1]] = 0; // 끊기
            con[wires[i][1]][wires[i][0]] = 0;

	    // 초기화
            cnt = 0;
            visited = new boolean[n+1];
            
            // BFS
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            visited[1] = true;
            while(!q.isEmpty()) {
                int start = q.poll();
                cnt++;
                for(int j=1;j<=n;j++) {
                    if(con[start][j] == 1 && !visited[j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
            
            con[wires[i][0]][wires[i][1]] = 1; // 다시 연결하기
            con[wires[i][1]][wires[i][0]] = 1;
            
            // 최소값 계산
            int tower = Math.abs(n-cnt*2);
            if(answer > tower) {
                answer = tower;
            }
        }
            
        return answer;
    }
}