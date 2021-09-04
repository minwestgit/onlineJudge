#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int n = A.size();
    int ans = 0;
    sort(A.begin(), A.end());
    for(int i=0;i<n-2;i++) {
        int j = i+1;
        int k = j+1;
        while(j<n-1) {
            if(k<n && A[i]+A[j] > A[k]) {
                k++;
            }                                             
            else {
                ans += k-j-1;
                j++;
            }
        }
    }
    return ans;
}