#include <algorithm>
#include <vector>

using namespace std;

int solution(int K, vector<int> &A) {
    int n = A.size();
    int sum = 0;
    int ans = 0;

    for(int i=0; i<n; i++){
        sum +=A[i];
        if(sum >= K){
            ans++;
            sum = 0;
        }
    }
    return ans;
}