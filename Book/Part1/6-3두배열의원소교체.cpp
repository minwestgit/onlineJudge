#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int n, k;
    cin >> n >> k;
    vector<int> a, b;
    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        a.push_back(x);
    }
    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        b.push_back(x);
    }

    sort(a.begin(), a.end()); // 오름차순 정렬
    sort(b.begin(), b.end(), greater<int>()); // 내림차순 정렬

    for(int i=0;i<k;i++) {
        if(a[i] < b[i]) {
            swap(a[i], b[i]);
        }
        // a의 원소가 b의 원소보다 크거나 같아질 때 반복문 종료
        else {
            break;
        }
    }

    long long ans = 0;
    for(int i=0;i<n;i++) {
        ans += a[i];
    }
    cout << ans << endl;

    return 0;
}