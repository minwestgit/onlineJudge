#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

// 플로이드워셜
using namespace std;

int n, m;
int students[501][501];
int ans = 0;

int main() {
    cin >> n >> m;
    for (int i = 0; i < 501; i++) {
        fill(students[i], students[i]+501, 1e9);
    }

    for(int i=1;i<=n;i++) {
        students[i][i] = 0;
    }

    for(int i=0;i<m;i++) {
        int a, b;
        cin >> a >> b;
        students[a][b] = 1;
    }

    for(int k=1;k<=n;k++) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                students[i][j] = min(students[i][j], students[i][k] + students[k][j]);
            }
        }
    }

    for(int i=1;i<=n;i++) {
        int cnt = 0;
        // 모든 학생과 성적 비교할 수 있는지 count
        for(int j=1;j<=n;j++) {
            if(students[i][j] != 1e9 || students[j][i] != 1e9) {
                cnt++;
            }
        }
        if(cnt == n) {
            ans++;
        }
    }

    cout << ans << endl;
}