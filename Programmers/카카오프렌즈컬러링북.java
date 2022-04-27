import java.util.*;
class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int areaCnt = 0; // 영역 갯수
        int maxCnt = 0; // 가장 큰 영역 칸 수
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && visited[i][j] == 0) {
                    int nodeCnt = 1; // 각 영역 크기 Count
                    
                    // BFS
                    q.add(new Node(i,j));
                    visited[i][j] = 1;
                    while(!q.isEmpty()) {
                        Node now = q.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];
                            if(nx >= 0 && ny >= 00 && nx < m && ny < n) {
                                if(picture[nx][ny] == picture[i][j] && visited[nx][ny] == 0) {
                                    q.add(new Node(nx,ny));
                                    visited[nx][ny] = 1;
                                    nodeCnt += 1;
                                }
                            }
                        }
                    }
                    
                    maxCnt = Math.max(maxCnt, nodeCnt);
                    areaCnt += 1;
                }
            }
        }
        answer[0] = areaCnt; answer[1] = maxCnt;
        return answer;
    }
}