#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define INF 1e9
    
using namespace std;

// 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
// 노드의 개수는 최대 100,000개라고 가정
int n, m, start;
vector<pair<int,int> > graph[30001];
int d[30001]; // 최단거리저장

void dijkstra(int start) {
    priority_queue<pair<int,int> > pq;
    pq.push(make_pair(0, start));
    d[start] = 0;
    while(!pq.empty()) {
        int dist = -pq.top().first;
        int now = pq.top().second;
        pq.pop();
        if(d[now] < dist) continue;
        for(int i=0;i<graph[now].size();i++) {
            int cost = dist + graph[now][i].second;
            if(cost < d[graph[now][i].first]) {
                d[graph[now][i].first] = cost;
                pq.push(make_pair(-cost, graph[now][i].first));
            }
        }
    }

}

int main(int argc, const char * argv[]) {
    
    cin >> n >> m >> start;

    for(int i=0;i<m;i++) {
        int x, y, z;
        cin >> x >> y >> z;
        graph[x].push_back(make_pair(y,z));
    }

    fill(d, d+3000, INF);

    dijkstra(start);

    int count = 0; // 도달할 수 있는 노드의 개수
    int maxDistance = 0; // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리

    for (int i=1;i<=n;i++) {
        if (d[i] != INF) {
            count += 1;
            maxDistance = max(maxDistance, d[i]);
        }
    }

    // 시작 노드는 제외해야 하므로 count-1
    cout << count-1 << ' ' << maxDistance << endl;

}