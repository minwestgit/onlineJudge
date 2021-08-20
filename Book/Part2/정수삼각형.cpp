#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
int d[501][501];

int main(int argc, const char * argv[]) {
    cin >> n;
    for (int i=0;i<n;i++) {
        for (int j=0;j<i+1;j++) {
            cin >> d[i][j];
        }
    }
    for(int i=1;i<n;i++) {
        for(int j=0;j<i+1;j++) {
            int left, right;
            // 대각선 왼쪽 위
            // 가장 왼쪽 수라면 접근 불가능
            if(j == 0) {
                left = 0;
            }
            else {
                left = d[i-1][j-1];
            }

            // 대각선 오른쪽 위
            // 가장 오른쪽 수라면 접근 불가능
            if(j == i) {
                right = 0;
            }
            else {
                right = d[i-1][j];
            }

            d[i][j] = d[i][j] + max(left, right);
        }
    }

    int ans = 0;
    for(int i=0;i<n;i++) {
        ans = max(ans, d[n-1][i]);
    }
    cout << ans << endl;

}