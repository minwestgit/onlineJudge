#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int v, e; // 노드의 개수(V)와 간선의 개수(E)
int parent[100001];

// 모든 노드에 대한 진입차수는 0으로 초기화
int indegree[100001];
// 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
vector<int> graph[100001];

// 위상 정렬 함수
void topologySort() {
    vector<int> result;
    queue<int> q;

    // 처음 시작할 때 진입차수가 0인 노드를 큐에 삽입
    for(int i=1;i<=v;i++) {
        if(indegree[i] == 0) {
            q.push(i);
        }
    }

    while(!q.empty()) {
        int now = q.front();
        q.pop();
        result.push_back(now);
        // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기(간선 제거)
        for(int i=0;i<graph[now].size();i++) {
            indegree[graph[now][i]] -= 1;
            // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
            if(indegree[graph[now][i]] == 0) {
                q.push(graph[now][i]);
            }
        }
    }

    // 위상 정렬을 수행한 결과 출력
    for (int i=0;i<result.size();i++) {
        cout << result[i] << ' ';
    }
}

int main(int argc, const char * argv[]) {
    
    cin >> v >> e;

    for(int i=0;i<e;i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b); // 정점 a->b
        // 진입 차수 +1
        // 특정한 노드로 들어오는 간선의 개수
        indegree[b] += 1; 
    }

    topologySort();

}