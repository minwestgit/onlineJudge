#include <iostream>
#include <algorithm>

using namespace std;

int solution(int A, int B, int K) {
    int ans = B/K - A/K;
    if(A%K == 0) ans++;
    return ans;
}
