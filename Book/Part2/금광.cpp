#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

// DP
using namespace std;

int t, n, m;
int arr[20][20];
int dp[20][20];

int main(int argc, const char * argv[]) {
    cin >> t;
    while(t--) {
        cin >> n >> m;
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                cin >> arr[i][j];
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = arr[i][j];
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                int leftUp, left, leftDown;
                // 왼쪽 위에서 이동
                if (i == 0) { 
                    leftUp = 0;
                }
                else {
                    leftUp = dp[i-1][j-1];
                }
                // 왼쪽에서 이동
                left = dp[i][j-1];
                // 왼쪽 아래에서 이동
                if(i == n-1) {
                    leftDown = 0;
                }
                else {
                    leftDown = dp[i+1][j-1];
                }
                dp[i][j] = dp[i][j] + max(leftUp, left, leftDown);
            }
        }

        int result = 0;
        // 가장 오른쪽 열에서 가장 큰 값이 최댓값
        for (int i=0;i<n;i++) {
            result = max(result, dp[i][m-1]);
        }

        cout << result << endl;
    }

}