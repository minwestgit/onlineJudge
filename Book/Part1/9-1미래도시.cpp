#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define INF 1e9 // 무한을 의미하는 값으로 10억을 설정
    
using namespace std;

int n, m;
int graph[501][501];

int main(int argc, const char * argv[]) {
    cin >> n >> m;

    // 최단 거리 테이블을 모두 무한으로 초기화
    for (int i = 0; i < 501; i++) {
        fill(graph[i], graph[i]+101, INF);
    }

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for(int i=1;i<=m;i++) {
        for(int j=1;j<=m;j++) {
            if(i==j) graph[i][j] = 0;
        }
    }

    // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
        // A와 B가 서로에게 가는 비용은 1이라고 설정
        int a, b;
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    // 거쳐 갈 노드 X와 최종 목적지 노드 K를 입력받기
    int x, k;
    cin >> x >> k;

    // 플로이드 워셜 알고리즘 수행
    for(int k=1;k<=n;k++) {
        for(int a=1;a<=n;a++) {
            for(int b=1;b<=n;b++) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
            }
        }
    }

    int distance = graph[1][k] + graph[k][x];

    if (distance >= INF) {
        cout << "-1" << '\n';
    }
    else {
        cout << distance << '\n';
    }
}