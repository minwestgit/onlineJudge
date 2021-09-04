#include <algorithm>

int solution(int N) {
    int ans = 0;
    for(long long i=1;i*i<=N;i++) {
        if(N%i == 0) {
            if(i*i == N) ans++;
            else ans += 2;
        }
    }

    return ans;
}