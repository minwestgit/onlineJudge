#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int v;
int indegree[501];
vector<int> graph[501];
int times[501]; // 강의시간

// 위상 정렬 함수
void topologySort() {
    vector<int> result(501); // 알고리즘 수행 결과를 담을 리스트

    for (int i=1;i<=v;i++) {
        result[i] = times[i];
    } 
    
    queue<int> q;

    for(int i=1;i<=v;i++) {
        if(indegree[i] == 0) {
            q.push(i);
        }
    }

    while(!q.empty()) {
        int now = q.front();
        q.pop();
        for(int i=0;i<graph[now].size();i++) {
            result[graph[now][i]] = max(result[graph[now][i]], result[now]+times[graph[now][i]]);
            indegree[graph[now][i]]--; // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            if(indegree[graph[now][i]] == 0) {
                q.push(graph[now][i]);
            }
        }
    }

    for(int i=1;i<=v;i++) {
        cout << result[i] << endl;
    }
}

int main(int argc, const char * argv[]) {
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >> v;
    for(int i=1;i<=v;i++) {
        int x;
        cin >> x;
        times[i] = x;
        while(1) {
            cin >> x;
            if(x == -1) break;
            indegree[i] += 1;
            graph[x].push_back(i);
        }
    }

    topologySort();

}