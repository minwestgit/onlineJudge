#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<int> arr;

int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }

    int start = 0;
    int end = *max_element(arr.begin(), arr.end());
    int ans = 0;
    while(start<=end) {
        long long total = 0;
        int mid = (start+end)/2;
        for(int i=0;i<n;i++) {
            // 잘랐을 때 떡의 양 계산
            if(arr[i] > mid ) { 
                total += arr[i] - mid;
            }
        }
        // 떡의 양이 부족한 경우 더 많이 자르기
        if(total < m) {
            end = mid - 1;
        }
        // 떡의 양이 충분한 경우 덜 자르기
        else {
            ans = mid; // 시간이 지날수록 최적화 된 값을 찾으므로, 답을 mid로 갱신
            start = mid + 1;
        }
        
    }
    cout << ans << endl;

    return 0;
}