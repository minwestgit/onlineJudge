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
        int[][] map = new int[51][51];
        int[][] visited = new int[51][51];
        int[][] d = new int[51][51];
        // 바깥 테두리 그리기
        for(int rec[] : rectangle) {
            int x1 = rec[0], y1 = rec[1];
            int x2 = rec[2], y2 = rec[3];
            for(int i=x1;i<=x2;i++) {
                for(int j=y1;j<=y2;j++) {
                    // 이미 선이 그려져있으면(map[i][j]가 2라면) 바깥 테두리가 아님
                    if((i==x1 || i==x2 || j==y1 || j==y2) && map[i][j] != 2) {
                        map[i][j] = 1;
                        map[i][j] = 1;
                    }
                    else {
                        map[i][j] = 2;
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        // BFS
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(characterX,characterY));
        visited[characterX][characterY] = 1;
        while(!q.isEmpty()) {
            Pair start = q.poll();
            int cnt = 0;
            // 갈 수 있는 곳 count
            for(int k=0;k<4;k++) {
                int nx = start.x + dx[k];
                int ny = start.y + dy[k];
                if(nx<0 || ny<0 || nx>=50 || ny>=50) continue;
                if(map[nx][ny]==1){
                    cnt++;
                }
            }
            
            for(int k=0;k<4;k++) {
                int nx = start.x + dx[k];
                int ny = start.y + dy[k];
                if(nx<0 || ny<0 || nx>=50 || ny>=50) continue;
                
                // 한번 더 갈 수 있는 곳 count
                int cnt2 = 0;
                for(int l=0;l<4;l++) {
                    int mx = nx + dx[l];
                    int my = ny + dy[l];
                    if(mx<0 || my<0 || mx>=50 || my>=50) continue;
                    if(map[mx][my]==1){
                        cnt2++;
                    }
                }
                
                // start와 nx/ny의 count가 둘 다 2 이상이면 돌아가야하는 곳
                if(cnt == 3 && cnt2 == 3) continue;
                
                if(map[nx][ny]==1 && visited[nx][ny]==0){
                    d[nx][ny] = d[start.x][start.y] + 1;
                    visited[nx][ny] =1;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        answer = d[itemX][itemY];
        
        for (int i = 0; i <= 10; i++){
            for (int j = 0; j <= 10; j++){
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        
        return answer;
    }
}