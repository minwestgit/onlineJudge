#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
 
int n, m;
int graph[1000][1000];

bool dfs(int x, int y) {
    // 범위 벗어나는지 체크
    if(x<0 || x>=n || y<0 || y>=m) return false;

    // 방문할 수 있으면 방문
    if(graph[x][y] == 0) {
        graph[x][y] = 1;
        dfs(x-1, y);
        dfs(x+1, y);
        dfs(x, y-1);
        dfs(x, y+1);
        return true;
    }
    return false;
}

int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            scanf("%1d", &graph[i][j]);
        }
    }

    int ans = 0;
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(dfs(i,j)) {
                ans++;
            }
        }
    }

    cout << ans << endl;

    return 0;
}