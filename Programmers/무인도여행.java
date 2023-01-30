import java.util.*;
class Solution {
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        char[][] map = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(!visit[i][j] && map[i][j] != 'X'){
                    Queue<Island> q = new LinkedList<>();
                    q.add(new Island(i,j));
                    visit[i][j] = true;
                    int sum = map[i][j]-'0';
                    while(!q.isEmpty()){
                        Island now = q.poll();
                        for(int k = 0; k < 4; k++){
                            int y = now.y + dy[k];
                            int x = now.x + dx[k];
                            if(y>=0 && y<map.length && x>=0 && x<map[0].length && !visit[y][x] && map[y][x]!='X'){
                                q.add(new Island(y,x));
                                sum += map[y][x]-'0';
                                visit[y][x]=true;
                            }
                        }
                    }
                    answer.add(sum);
                }
            }
        }
        
        Collections.sort(answer);
        if(answer.size() == 0) answer.add(-1);
    
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    public int dfs(int x, int y, String[] maps, boolean[][] visit) {
        if(x<0 || x>=maps.length || y<0 || y>=maps[0].length() || visit[x][y] || maps[x].charAt(y) == 'X') return 0;
        visit[x][y] = true;
        return (maps[x].charAt(y)-'0')
            + dfs(x+1, y, maps, visit) + dfs(x-1, y, maps, visit) + dfs(x, y+1, maps, visit) + dfs(x, y-1, maps, visit);
    }
}

class Island {
    int y, x;
    
    public Island(int y, int x){
        this.y = y;
        this.x = x;
    }
}