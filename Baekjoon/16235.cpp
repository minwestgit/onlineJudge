#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <map>
#include <set>
#include <math.h>
using namespace std;
struct Tree {
    int x, y;
    int age;
};

int n, m, k;
int add[10][10];
int food[10][10];
int dy[] = { -1,-1,-1,0,0,1,1,1 };
int dx[] = { -1,0,1,-1,1,-1,0,1 };

vector<int> tree[11][11];
vector<Tree> dead;

void spring() {
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            sort(tree[i][j].begin(), tree[i][j].end()); // 나이 순 정렬
        }
    }
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            // 해당 위치에 존재하는 나무 수 만큼 반복
            for(int k=0;k<tree[i][j].size();k++) {
                // 양분 먹지 못하면 죽음
                if(food[i][j] < tree[i][j][k]) {
                    dead.push_back({i, j, tree[i][j][k]});
                    tree[i][j].erase(tree[i][j].begin()+k);
                    k--;
                }
                // 나이 증가
                else {
                    food[i][j] -= tree[i][j][k]; // 양분 먹기
                    tree[i][j][k]++;
                }
            }
        }
    }
}

void summer() {
    // 죽은 나무를 양분으로
    for(int i=0;i<dead.size();i++) {
        food[dead[i].x][dead[i].y] += dead[i].age/2;
    }
    // 매년 초기화
    dead.clear();
    dead.resize(0);
}

void autumn() {
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            int size = tree[i][j].size();
            // 해당 위치에 존재하는 나무 수 만큼 반복
            for(int k=0;k<size;k++) {
                // 5의 배수면 나무 번식
                if(tree[i][j][k]%5 == 0 && tree[i][j][k] != 0) {
                    for(int r=0;r<8;r++) {
                        int nx = i+dx[r];
                        int ny = j+dy[r];
                        if(nx>=0 && nx<n && ny>=0 && ny<n) {
                            tree[nx][ny].push_back(1);
                        }
                    }
                }
            }
        }
    }
}

void winter() {
    // S2D2가 양분 추가
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            food[i][j] += add[i][j];
        }
    }
}

void solution() {
    for(int i=0;i<k;i++){
        spring();
        summer();
        autumn();
        winter();
    }

    // 살아있는 나무 개수 구하기
    int ans = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            ans += tree[i][j].size();
        }
    }
    cout << ans << endl;
}

void input() {
    cin >> n >> m >> k;

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            food[i][j] = 5;
            cin >> add[i][j];
        }
    }
    
    for(int i=0;i<m;i++) {
        int x, y, z;
        cin >> x >> y >> z;
        tree[x-1][y-1].push_back(z);
    }

}

int main(int argc, const char * argv[]) {
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    input();
    solution();

    return 0;
}
