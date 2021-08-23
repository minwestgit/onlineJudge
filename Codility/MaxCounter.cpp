#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(int N, vector<int> &A) {

    vector<int> v(N);
    int max = 0, tmpMax = 0;

    fill(v.begin(), v.end(), 0);

    for(int i=0;i<A.size();i++) {
        if(A[i] == N+1) {
            max = tmpMax;
        }
        else {
            // max보다 작으면 max+1
            if(v[A[i]-1] < max) {
                v[A[i]-1] = max+1;
            }
            // max 이상이면 +1
		    else {
                v[A[i]-1]++;
            }

            // 최댓값 갱신
            if(v[A[i]-1] > tmpMax) {
                tmpMax = v[A[i]-1];
            }
        }
    }

    for(int i=0;i<N;i++){
        // max보다 작은 값들 max로 채움
	    if(v[i] < max) {
            v[i] = max;
        }
	}

    return v;
}