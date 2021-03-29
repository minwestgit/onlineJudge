#include <string>
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    int map[101][101] = {0, };
    int d[101][101]; // 최단 경로 저장할 배열
    
    // 물이 잠긴 지역 -1로 표시
    for(int i=0;i<puddles.size();i++) {
        map[puddles[i][1]][puddles[i][0]] = -1;
    }
    
    d[1][0] = 1; // 시작은 1
    
    for(int i=1;i<=n;i++) {
        for(int j=1;j<=m;j++) {
            // 물이 잠긴 곳은 갈 수 없으므로 0
            if(map[i][j] == -1) d[i][j] = 0;
            // 최단 경로 수 = 왼쪽, 위쪽의 경로 수의 합
            else d[i][j] = (d[i-1][j]+d[i][j-1]) % 1000000007;
        }
    }
        
    answer = d[n][m];
    return answer;
}