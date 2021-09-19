#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int n = A.size();
    int d[n];
    d[0] = A[0];
    for(int i=1;i<n;i++) {
        if(A[i]+d[i-1] > A[i]) {
            d[i] = A[i]+d[i-1];
        }
        else {
            d[i] = A[i];
        }
    }
    int max = -2147483648;
    for(int i=0;i<n;i++) {
        if(d[i] > max) max = d[i];
    }
    return max;
}