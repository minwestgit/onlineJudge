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
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(!visit[i][j] && map[i][j] != 'X') { //새로운 무인도 발견
                    Queue<Island> q = new LinkedList<>();
                    q.add(new Island(i,j));
                    visit[i][j] = true;
                    int sum = map[i][j]-'0';
                    while(!q.isEmpty()) { //무인도 탐색
                        Island now = q.poll();
                        for(int k = 0; k < 4; k++){
                            int x = now.x + dx[k];
                            int y = now.y + dy[k];
                            if(x>=0 && x<map.length && y>=0 && y<map[0].length && !visit[x][y] && map[x][y]!='X') {
                                q.add(new Island(x,y));
                                sum += map[x][y]-'0';
                                visit[x][y] = true;
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
}

class Island {
    int y, x;
    
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}