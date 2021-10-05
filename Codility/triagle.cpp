#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    sort(A.begin(), A.end());

    if(A.size() < 3) return 0;

    for (int i=0;i<A.size()-2;i++) {
        if ((long long)A[i+1] + A[i] > (long long)A[i+2]) {
            return 1;
        }
    }

    return 0;
}