#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<int> arr;

int main(int argc, const char * argv[]) {

    cin >> n >> m;

    for (int i=0;i<n;i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }

    vector<int> d(m+1, 10001);

    d[0] = 0;
    /*
    for (int i=0;i<n;i++) {
        for (int j=arr[i];j<=m;j++) {
            // (i-k)원을 만드는 방법이 존재하는 경우
            if (d[j-arr[i]] != 10001) {
                d[j] = min(d[j], d[j-arr[i]]+1);
            }
        }
    }
    */
   // 그냥 반대로 해봄..
    for(int i=arr[0];i<=m;i++) { // arr[0]부터 시작하는 이유 : d[i-arr[j]]가 d[0]이 되는 값부터 시작하면 되므로
        for(int j=0;j<n;j++) {
            if(d[i-arr[j]] != 10001) {
                d[i] = min(d[i], d[i-arr[j]]+1);
            }
        }
    }

    if (d[m] == 10001) {
        cout << -1 << endl; // m원을 만드는 방법이 없는 경우
    }
    else {
        cout << d[m] << endl;
    }
}