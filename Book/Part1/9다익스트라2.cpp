#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>
#define INF 1e9
    
using namespace std;

/*
* 개선된 다익스트라 알고리즘
* 우선순위 큐를 사용
* 시간 복잡도 O(NlogN)
*/

// 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
// 노드의 개수는 최대 100,000개라고 가정
int n, m, start;
vector<pair<int,int> > graph[100001];
int d[100001]; // 최단거리저장

void dijkstra(int start) {
    priority_queue<pair<int,int> > pq;
    pq.push(make_pair(0, start));
    d[start] = 0;
    while(!pq.empty()) {
        // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        // 최단 거리를 찾기 위해 큐에 값을 넣고 뺄 때 -를 붙임.
        int dist = -pq.top().first;
        int now = pq.top().second;
        pq.pop();
        // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        // 현재 노드의 최단 거리 < 우선순위큐에서 뒤로 밀린 것
        if(d[now] < dist) {
            continue;
        }
        // 현재 노드와 연결된 다른 인접한 노드들을 확인
        for(int i=0;i<graph[now].size();i++) {
            int cost = dist + graph[now][i].second;
            // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if(cost < d[graph[now][i].first]) {
                d[graph[now][i].second] = cost;
                pq.push(make_pair(-cost, graph[now][i].first));
            }
        }
    }

}

int main(int argc, const char * argv[]) {
    
    cin >> n >> m >> start;
    for(int i=0;i<m;i++) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a].push_back(make_pair(b,c));
    }

    memset(d, INF, sizeof(d));

    dijkstra(start);

    // 모든 노드로 가기 위한 최단 거리를 출력
    for(int i=1;i<=n;i++) {
        if (d[i] == INF) {
            cout << "INFINITY" << endl;
        }
        else {
            cout << d[i] << endl;
        }
    }
}