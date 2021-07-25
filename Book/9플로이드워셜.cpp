#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define INF 1e9 // 무한을 의미하는 값으로 10억을 설정
    
using namespace std;

/*
* 플로이드 워셜 알고리즘
* 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구하는 알고리즘
* 시간 복잡도 O(N^3)
*/

// 노드의 개수(N), 간선의 개수(M)
// 노드의 개수는 최대 500개라고 가정
int n, m;
// 2차원 배열(그래프 표현)를 만들기
int graph[501][501];

int main(int argc, const char * argv[]) {
    cin >> n >> m;

    // 최단 거리 테이블을 모두 무한으로 초기화
    for (int i = 0; i < 501; i++) {
        //memset(graph[i], INF, sizeof(graph[i]+501));
        fill(graph[i], graph[i]+501, INF);
    }

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for(int i=1;i<=m;i++) {
        for(int j=1;j<=m;j++) {
            if(i==j) graph[i][j] = 0;
        }
    }

    // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
        // A에서 B로 가는 비용은 C라고 설정
        int a, b, c;
        cin >> a >> b >> c;
        graph[a][b] = c;
    }

    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
    for(int k=1;k<=n;k++) {
        for(int a=1;a<=n;a++) {
            for(int b=1;b<=n;b++) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
            }
        }
    }

    // 수행된 결과를 출력
    for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            if (graph[a][b] == INF) {
                cout << "INFINITY" << ' ';
            }
            else {
                cout << graph[a][b] << ' ';
            }
        }
        cout << endl;
    }
}