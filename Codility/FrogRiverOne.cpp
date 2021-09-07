#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int d[100001] = {0, };

int solution(int X, vector<int> &A) {

    int len = A.size();
    int cnt = 0;
    for(int i=0;i<len;i++) {
        if(d[A[i]] == 0) {
            d[A[i]] = 1;
            cnt++;
        }
        if(cnt == X) {
            return i;
        }
    }
    return -1;
}