#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int n = A.size();
    vector<int> tmp;
    for(int i=0;i<n;i++) {
        tmp.push_back(abs(A[i]));
    }
    sort(tmp.begin(), tmp.end());
    tmp.erase(unique(tmp.begin(), tmp.end()), tmp.end());
    return tmp.size();
}
