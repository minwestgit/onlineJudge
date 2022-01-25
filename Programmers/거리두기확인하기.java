import java.util.*;
class 거리두기확인하기 {
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0;i < places.length;i++) {
            boolean chk = true;
            String[] place = places[i];
            // 대기실별 거리두기 여부 구하기
            for(int r = 0;r < 5;r++) {
                for(int c = 0;c < 5; c++) {
                    // P(응시자) 대상 거리두기 여부 체크
                    if(place[r].charAt(c) == 'P') {
                        if(!bfs(place,r,c)) chk = false;
                    }
                }
            }
            answer[i] = chk ? 1 : 0;
        }
        return answer;
    }
    
    public boolean bfs(String[] place, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int k = 0;k < 4;k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if(nx < 0 || nx > 4 || ny < 0 || ny > 4 || (nx == x && ny == y)) continue; // 출발점(x,y)은 제외
                int manhattan = Math.abs(nx-x) + Math.abs(ny-y); // 맨해튼 거리 계산
                if(manhattan > 2) continue;
                // P 사방에 P가 존재하면 false
                if(place[nx].charAt(ny) == 'P' && manhattan <= 2) {
                    return false;
                }
                // P 사방에 O가 존재한다면 O를 Queue에 넣어 주변에 P가 있는지 탐색함.
                else if(place[nx].charAt(ny) == 'O' && manhattan < 2) {
                    q.add(new Node(nx,ny));
                }
            }
        }
        return true;
    }
    
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

