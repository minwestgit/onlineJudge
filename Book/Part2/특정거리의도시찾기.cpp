#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

// BFS/DFS
using namespace std;

int n, m, k, x;
vector<int> graph[300001];
vector<int> d(300001, -1);

int main(int argc, const char * argv[]) {
    cin >> n >> m >> k >> x;

    for(int i=0;i<m;i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
    }

    // 출발 도시에 대한 처리
    d[x] = 0;
    queue<int> q;
    q.push(x);

    while(!q.empty()) {
        int now = q.front();
        q.pop();
        for(int i=0;i<graph[now].size();i++) {
            int next = graph[now][i];
            // 아직 방문하지 않은 도시라면
            if(d[next] == -1) {
                d[next] = d[now]+1;
                q.push(next);
            }
        }
    }

    bool chk = false;
    for(int i=1;i<=n;i++) {
        if(d[i] == k) {
            cout << i << endl;
            chk = true;
        }
    }

    // 최단 거리가 K인 도시가 존재하지 않으면 -1 출력
    if(!chk) {
        cout << -1 << endl;
    }

}