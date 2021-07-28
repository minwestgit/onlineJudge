#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int n, k;
    cin >> n >> k;

    int ans = 0;

    while(1) {
        int tmp = n/k;
        if(tmp==0) break;
        ans += n - tmp*k; // n이 k의 배수가 될 때 까지 빼주기.
        n = tmp;
        ans++;
    }

    cout << ans;

    return 0;
}
