#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m, x, y, dir;
int d[50][50]; // 방문여부 기록
int arr[50][50];

// 북,동,남,서
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main(int argc, const char * argv[]) {
    cin >> n >> m;
    cin >> x >> y >> dir;

    memset(d, 0, sizeof(d)); // d 초기화
    d[x][y] = 1; // 시작 위치 방문

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin >> arr[i][j];
        }
    }

    int cnt = 1;
    int turnCnt = 0;
    while(1) {

        // 1단계 : 왼쪽 방향으로 회전
        dir -= 1;
        if(dir == -1) dir = 3;

        // 2단계 : 가보지 않은 칸이 존재하는 경우 이동
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(arr[nx][ny] != 1 && d[nx][ny] == 0) {
            x = nx;
            y = ny;
            d[x][y] = 1;
            cnt++;
            turnCnt = 0;
            continue;
        } 
        // 가보지 않은 칸이 없거나 바다인 경우 1단계로 돌아감
        else {
            turnCnt++;
        }

        // 3단계 : 네 방향 모두 갈 수 없는 경우
        if(turnCnt == 4) {
            nx = x - dx[dir];
            ny = y - dy[dir];
            // 뒤로 한 칸 이동
            if(arr[nx][ny] == 0) {
                x = nx;
                y = ny;
                turnCnt = 0;
                break;
            }
            else break; // 바다이면 멈춤
        }
    }

    cout << cnt << endl;
    
    return 0;
}