import java.util.*;
class Solution {
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0 ,0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        int answer = 0;
        //map setting
        map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        //방문기록 초기화
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            Arrays.fill(visited[i], false);
        }
        
        //시작, 출구, 레버 위치 찾기
        Pos start = findPos('S');
        Pos end = findPos('E');
        Pos lever = findPos('L');
        
        //시작~레버 최소 시간 구하기
        answer = bfs(start, lever);
        if(answer == -1) return -1;

        //방문기록 초기화
        for(int i =0 ; i < maps.length; i++){
            Arrays.fill(visited[i], false);
        }

        //레버~출구 최소 시간 구하기
        int leverToEnd = bfs(lever, end);
        if(leverToEnd == -1) return -1;
        answer += leverToEnd;

        return answer;
    }
    
    public int bfs(Pos start, Pos end) {
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        
        visited[start.x][start.y] = true;
        
        while(!q.isEmpty()) {
            Pos now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int ncount = now.count+1;
                
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length
                   && map[nx][ny] != 'X' && !visited[nx][ny]) {
                    q.add(new Pos(nx, ny, ncount));
                    visited[nx][ny] = true;
                }
                
                if(nx == end.x && ny == end.y) return ncount;
            }
        }
        return -1;
    }
    
    public Pos findPos(char c) {
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(c == map[i][j]) return new Pos(i, j, 0);
            }
        }
        return new Pos(-1, -1, 0);
    }
}

class Pos {
    int x;
    int y;
    int count;
    public Pos(int x, int y, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}