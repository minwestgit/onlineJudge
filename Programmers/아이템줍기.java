import java.util.*;
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class 아이템줍기 {
    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        int[][] visited = new int[101][101];
        int[][] d = new int[101][101];
        
        // 바깥 테두리 그리기(2배)
        for(int rec[] : rectangle) {
            int x1 = rec[0]*2, y1 = rec[1]*2;
            int x2 = rec[2]*2, y2 = rec[3]*2;
            for(int i=x1;i<=x2;i++) {
                for(int j=y1;j<=y2;j++) {
                    // 이미 선이 그려져있으면(map[i][j]가 2라면) 바깥 테두리가 아님
                    if((i==x1 || i==x2 || j==y1 || j==y2) && map[i][j] != 2) {
                        map[i][j] = 1;
                    }
                    else {
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        // BFS
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(characterX*2,characterY*2)); // 2배니까 x2
        visited[characterX*2][characterY*2] = 1;
        while(!q.isEmpty()) {
            Pair start = q.poll();
            for(int k=0;k<4;k++) {
                int nx = start.x + dx[k];
                int ny = start.y + dy[k];
                if(nx<0 || ny<0 || nx>100 || ny>100) continue; 
                if(map[nx][ny]==1 && visited[nx][ny]==0){
                    d[nx][ny] = d[start.x][start.y] + 1;
                    visited[nx][ny] =1;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        
        answer = d[itemX*2][itemY*2]/2; // 2배니까 거리는 /2       
        return answer;
    }
}
