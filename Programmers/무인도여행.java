import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            int sum = 0;
            for(int j = 0; j < maps[0].length(); j++) {
                sum = dfs(i, j, maps, visit);
                if(sum > 0) answer.add(sum);
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