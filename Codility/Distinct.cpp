#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    sort(A.begin(), A.end());
    A.erase(unique(A.begin(), A.end()), A.end());

    return A.size();
}