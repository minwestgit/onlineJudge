#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    sort(A.begin(), A.end(), greater<>());
    int endIdx = A.size()-1;
    int ans = A[0]*A[1]*A[2];
    // 음수*음수*양수가 최대값이 되는 경우 고려
    if(A[endIdx] < 0 && A[endIdx-1] < 0) {
        ans = max(ans, A[endIdx]*A[endIdx-1]*A[0]);
    }

    return ans;
}