import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        // 2차원 배열로 변환
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true) {
            boolean[][] chk = new boolean[m][n]; // 지워질 블럭 체크용
            for(int i=0;i<m-1;i++) {
                for(int j=0;j<n-1;j++) {
                    char c = map[i][j];
                    // 2X2가 같은 문자면 지워질 문자로 체크
                    if(c != '0') {
                        if(map[i+1][j] == c && map[i][j+1] == c && map[i+1][j+1] == c) {
                            chk[i][j] = true;
                            chk[i+1][j] = true;
                            chk[i][j+1] = true;
                            chk[i+1][j+1] = true;
                        }
                    }
                }
            }
            
            int cnt = 0;
            // 줄 마다 블록을 아래로 떨어뜨려 빈 공간 없애기
            for(int j=0;j<n;j++) {
                Queue<Character> q = new LinkedList<>();
                // 떨어질 문자열 Queue에 보관
                for(int i=m-1;i>=0;i--) {
                    if(chk[i][j] == true) cnt++;
                    else q.add(map[i][j]);
                }
                
                // 아래부터 블럭 쌓고 빈 공간은 0으로 변경
                for(int i=m-1;i>=0;i--) {
                    if(q.isEmpty()) map[i][j] = '0';
                    else map[i][j] = q.poll();
                }
            }
            answer += cnt;
            if(cnt == 0) break; // 지워질 블록이 없으면 종료
        }
        return answer;
    }
}