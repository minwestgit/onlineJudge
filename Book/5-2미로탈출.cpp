#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main(int argc, const char * argv[]) {
    int n, m;
    int map[201][201];
    cin >> n >> m;

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            scanf("%1d", &map[i][j]);
        }
    }

    //BFS
    queue< pair<int,int> > q;
    q.push(make_pair(0,0));

    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue; // 미로 공간 벗어나는지 체크
            if(map[nx][ny] == 0) continue; // 괴물이 존재하는지 체크
            if(map[nx][ny] == 1) {
                map[nx][ny] = map[x][y] + 1;
                q.push(make_pair(nx, ny));
            }
        }
    }

    cout << map[n-1][m-1] << endl;

    return 0;
}