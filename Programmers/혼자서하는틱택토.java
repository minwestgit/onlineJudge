class Solution {
    char[][] map;
    public int solution(String[] board) {
        int answer = 1;
        map = new char[3][3];
        int oCnt = 0; int xCnt = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'O') oCnt++;
                if(map[i][j] == 'X') xCnt++;
            }
        }
        
        if(oCnt < xCnt) return 0; //O차례인데 X
        if(oCnt > xCnt+1) return 0; //X차례인데 O 한 번 더
        
        if(winChk('O') > 0 && oCnt <= xCnt) return 0; //o가 이기면 ocnt > xcnt
        if(winChk('X') > 0 && oCnt > xCnt) return 0; //x가 이기면 xcnt = ocnt
        
        return answer;
    }
    
    public int winChk(char c) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            //가로
            if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                cnt += 1; 
            //세로
            if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i])
                cnt += 1;
        }
        //대각선
        if(map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2]) cnt += 1;
        if(map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0]) cnt += 1;
        return cnt;
    }
}