#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n, m;
int graph[101][101];

int main(int argc, const char * argv[]) {
    cin >> n;
    cin >> m;

    // 최단 거리 테이블을 모두 무한으로 초기화
    for (int i=0;i<101;i++) {
        fill(graph[i], graph[i]+101, 1e9);
    }

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for(int i=1;i<=n;i++) {
        for(int j=1;j<=n;j++) {
            if(i==j) graph[i][j] = 0;
        }
    }

    for(int i=0;i<m;i++) {
        int start, end, cost;
        cin >> start >> end >> cost;
        if (cost < graph[start][end]) graph[start][end] = cost;
    }

    // 플로이드 워셜 알고리즘을 수행
    for(int k=1;k<=n;k++) {
        for(int a=1;a<=n;a++) {
            for(int b=1;b<=n;b++) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
            }
        }
    }

    for(int i=1;i<=n;i++) {
        for(int j=1;j<=n;j++) {
            if(graph[i][j] == 1e9) {
                cout << "0 ";
            }
            else {
                cout << graph[i][j] << " ";
            }
        }
        cout << endl;
    }

}