#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
int T[16], P[16];
int dp[16];

int main() {
   cin >> n;
   for(int i=0;i<n;i++) {
       cin >> T[i] >> P[i];
   }

   for (int i = 0; i < n; i++) {        
        dp[i+T[i]] = max(dp[i+T[i]], dp[i]+P[i]);        
        dp[i+1] = max(dp[i+1], dp[i]);
    }

    cout << dp[n];
}