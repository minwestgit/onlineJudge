#include <iostream>
#include <algorithm>
#include <vector>

// 이진 탐색
using namespace std;

int n;
vector<int> v;

int main() {
    cin >> n;
    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }
    
    int start = 0;
    int end = v.size()-1;
    int ans = -1;

    while(start<=end) {
        int mid = (start+end)/2;
        if(v[mid] = mid) {
            ans = mid;
            break;
        }
        else if(v[mid] < mid) {
            start = mid+1;
        }
        else {
            end = mid-1;
        }
    }
    cout << ans << endl;
}