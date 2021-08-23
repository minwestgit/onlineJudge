#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    sort(A.begin(), A.end());

    int num = 1;
    for(int i=0;i<A.size();i++) {
        if(num != A[i]) {
            return 0;
        }
        num++;
    }
    return 1;
}