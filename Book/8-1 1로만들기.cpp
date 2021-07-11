#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int d[30001];
int x;

int main(int argc, const char * argv[]) {
    
    cin >> x;
    d[0] = d[1] = 0;

    // bottom_up
    for (int i=2;i<=x;i++) {

        // 현재의 수에서 1을 빼는 경우
        d[i] = d[i - 1] + 1;
        // 현재의 수가 2로 나누어 떨어지는 경우
        if (i % 2 == 0)
            d[i] = min(d[i], d[i/2] + 1);
        // 현재의 수가 3으로 나누어 떨어지는 경우
        if (i % 3 == 0)
            d[i] = min(d[i], d[i/3] + 1);
        // 현재의 수가 5로 나누어 떨어지는 경우
        if (i % 5 == 0)
            d[i] = min(d[i], d[i/5] + 1);
    }

    cout << d[x] << endl;
}