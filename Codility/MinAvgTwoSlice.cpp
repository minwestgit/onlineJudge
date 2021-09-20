#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    float minAvg = (A[0] + A[1]) / 2;
    int minIdx = 0;

    for (int i = 2; i < A.size(); i++) {
        float avg = (float)(A[i-2] + A[i-1] + A[i]) / (float)3;
        if (minAvg > avg) {
            minAvg = avg;
            minIdx = i - 2;
        }

        avg = (float)(A[i-1] + A[i]) / (float)2;
        if (minAvg > avg) {
            minAvg = avg;
            minIdx = i - 1;
        }
    }

    return minIdx;
}
