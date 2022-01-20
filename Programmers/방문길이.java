class 방문길이 {
    int[] dx = {0, 0, 1, -1}; // U, D, R, L
    int[] dy = {1, -1, 0, 0};
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        
        // 배열 인덱스에 음수를 넣을 수 없으므로 -5~5를 0~10으로 변환
        int x = 5, y = 5; // (0,0) -> (5,5)
        char[] ch = dirs.toCharArray();
        for(Character c : ch) {
            int nx = x, ny = y; // 움직일 좌표
            if(c == 'U') {
                nx += dx[0];
                ny += dy[0];
            } 
            else if(c == 'D') {
                nx += dx[1];
                ny += dy[1];
            }
            else if(c == 'R') {
                nx += dx[2];
                ny += dy[2];
            }
            else if(c == 'L') {
                nx += dx[3];
                ny += dy[3];
            }
            // 좌표평면을 벗어나는지 Check
            if(nx > 10 || nx < 0 || ny > 10 || ny < 0) {
                continue;
            }
            
            // UDU는 1이 됨을 고려해야함!!
            // 그러므로 어디서 왔는지도 체크해야 함
            if(!visited[nx][ny][x][y] && !visited[x][y][nx][ny]) {
                visited[nx][ny][x][y] = true;
                visited[x][y][nx][ny] = true;
                answer += 1;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}