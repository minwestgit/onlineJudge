#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int n, m;
    cin >> n >> m;
    int a[100][100];
    int ans = 0;

    for(int i=0;i<n;i++) {
        int min = 10000;
        for(int j=0;j<m;j++) {
            cin >> a[i][j];
            if(a[i][j] < min) min = a[i][j];
        }
        if(ans < min) ans = min;
    }

    cout << ans;

    return 0;
}