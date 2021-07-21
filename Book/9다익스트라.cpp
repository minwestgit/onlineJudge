#include <iostream>
#include <vector>
#include <algorithm>
#define INF 1e9

using namespace std;

// 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
// 노드의 개수는 최대 100,000개라고 가정
int n, m, start;
vector<pair<int,int> > graph[100001];
bool visited[100001]; // 방문한 노드 체크
int d[100001]; // 최단거리저장

// 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
int getSmallestNode() {
    int min_value = INF;
    int index = 0;
    for(int i=1;i<=n;i++) {
        if(d[i] < min_value && !visited[i]) {
            min_value = d[i];
            index = i;
        }
    }
}

void dijkstra(int start) {
    visited[start] = true;
    d[start] = 0;

    for(int j=0;j<graph[start].size();j++) {
        d[graph[start][j].first] = graph[start][j].second;
    }

    // 시작 노드를 제외한 n-1개 노드에 대해 반복
    for(int i=0;i<n-1;i++) {
        // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
        int now = getSmallestNode();
        visited[now] = true;
        // 현재 노드와 연결된 다른 노드를 확인
        for(int j=0;j<graph[now].size();j++) {
            int cost = graph[now][j].second;
            // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if(cost < d[graph[now][j].first]) {
                d[graph[now][j].first] = cost;
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