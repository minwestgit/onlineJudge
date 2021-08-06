#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
int parent[100001];

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
    
    cin >> n >> m;

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for(int i=1;i<=n;i++) {
        parent[i] = i;
    }

    for(int i=0;i<m;i++) {
        int oper, a, b;
        cin >> oper >> a >> b;

        // union
        if(oper == 0) {
            unionParent(a, b);
        }
        //find
        else if(oper == 1) {
            if(findParent(a) == findParent(b)) {
                cout << "YES" << endl;
            }
            else {
                cout << "NO" << endl;
            }
        }
    }

}