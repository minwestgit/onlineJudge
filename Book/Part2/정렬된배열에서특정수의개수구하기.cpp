#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

// 이진탐색
using namespace std;

int n, x;
vector<int> v;

int main(int argc, const char * argv[]) {
    cin >> n >> x;
    for(int i=0;i<n;i++) {
        int a;
        cin >> a;
        v.push_back(a);
    }

    int ans = 0;
    int up = upper_bound(v.begin(), v.end(), x) - v.begin();
    int low = lower_bound(v.begin(), v.end(), x) - v.begin();

    ans = up-low;

    if (ans == 0) {
        cout << -1 << endl;
    }
    else {
        cout << ans << endl;
    }

}