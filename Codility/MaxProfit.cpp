#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int n = A.size();
    
    // 원소가 없으면 0
    if(n == 0) return 0;
    
    int min = A[0];
    int ans = 0;
    for(int i=0;i<n;i++) {
        if(A[i] < min) {
            min = A[i];
        }
        // 최솟값 기준으로 비교
        if(A[i] > min) {
            ans = max(ans, A[i]-min);
        }
    }
    if(ans < 0) return 0;
    return ans;
}