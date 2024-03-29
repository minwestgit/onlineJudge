#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int v, e;
int parent[100001];

vector<pair<int, pair<int, int> > > edges;
int result = 0;

int findParent(int x) {
    // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if(x == parent[x]) {
        return x;
    }
    return parent[x] = findParent(parent[x]);
}

// 두 원소가 속한 집합을 합치기
void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if(a < b) {
        parent[b] = a;
    }
    else {
        parent[a] = b;
    }
}

int main(int argc, const char * argv[]) {
    
    cin >> v >> e;

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for(int i=1;i<=v;i++) {
        parent[i] = i;
    }

    for(int i=0;i<e;i++) {
        int a, b, cost;
        cin >> a >> b >> cost;
        edges.push_back(make_pair(cost,make_pair(a,b)));
    }

    sort(edges.begin(), edges.end());
    int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

    for(int i=0;i<edges.size();i++) {
        int cost = edges[i].first;
        int a = edges[i].second.first;
        int b = edges[i].second.second;
        // 사이클이 발생하지 않는 경우에만 집합에 포함
        if(findParent(a) != findParent(b)) {
            unionParent(a,b);
            result += cost;
            last = cost;
        }
    }

    // 최소 신장 트리의 모든 간선의 합 - 가장 비용이 큰 간선 => 2개의 최소 신장 트리로 분리
    cout << result - last << endl;

}