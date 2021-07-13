#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int d[1001];
int n;

int main(int argc, const char * argv[]) {
    
    cin >> n;

    d[1] = 1;
    d[2] = 3;
    
    for (int i=3;i<=n;i++) {
        d[i] = (d[i-1] + d[i-2]*2) % 796796;
    }

    cout << d[n] << endl;
}