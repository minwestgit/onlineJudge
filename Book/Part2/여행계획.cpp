#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

// 그래프
using namespace std;

int n, m;
int parent[501];

int findParent(int x) {
    if(x == parent[x]) {
        return x;
    }
    else {
        return parent[x] = findParent(parent[x]);
    }
}

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
    cin >> n >> m;    
    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for(int i=1;i<=n;i++) {
        parent[i] = i;
    }

    for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++) {
            int x;
            cin >> x;
            // 연결된 경우 Union 연산 수행
            if (x == 1) {
                unionParent(i+1, j+1);
            }
        }
    }

    vector<int> v(m);
    for(int i=0;i<m;i++) {
        cin >> v[i];
    }

    bool ans = true;
    for(int i=0;i<m-1;i++) {
        // 여행 계획에 속하는 노드의 부모가 같은지 확인
        if(findParent(v[i]) != findParent(v[i+1])) {
            ans = false;
        }
    }

    if(ans) {
        cout << "YES" << endl;
    }
    else {
        cout << "NO" << endl;
    }
}