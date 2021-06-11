#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int N, M, K;
    vector<int> a(N);
    int ans = 0;

    for(int i=0;i<N;i++) {
        cin >> a[i];
    }

    sort(a.begin(), a.end(), greater<int>());

    // 가장 큰 수가 더해지는 횟수
    // M/(K+1) -> 수열이 반복되는 횟수
    int count = (int)(M/(K+1))*K;
    count += M%(K+1); // M이 K+1로 나누어떨어지지 않는 경우
    
    ans += count * a[0];
    ans += (M-count)*a[1];

    cout << ans;

    return 0;
}