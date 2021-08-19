#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m;
int res = 0;
int map[10][10];
int tmp[10][10];

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

void virus(int x, int y) {
    for(int k=0;k<4;k++) {
       int nx = x+dx[k];
       int ny = y+dy[k];
       if(nx>=0 && nx<n && ny>=0 && ny<m) {
           if(tmp[nx][ny] == 0) {
               tmp[nx][ny] = 2;
               virus(nx, ny);
           }
       }
    }
}

int mapCnt() {
    int cnt = 0;
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(tmp[i][j] == 0) {
                cnt++;
            }
        }
    }
    if(cnt > res) {
        res = cnt;
    }
    return res;
}

void dfs(int count) {
    if(count == 3) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                tmp[i][j] = map[i][j];
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(tmp[i][j] == 2) {
                    virus(i, j);
                }
            }
        }
        mapCnt();
        return;
    }

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(map[i][j] == 0) {
                map[i][j] = 1;
                count++;
                dfs(count);
                count--;
                map[i][j] = 0;
            }
        }
    }

}

int main() {
    cin >> n >> m;
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin >> map[i][j];
        }
    }

    dfs(0);

    cout << res << endl;
}