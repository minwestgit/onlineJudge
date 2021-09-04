#include <algorithm>

using namespace std;

int solution(int N) {
    int ans = 2147483647;
    for(int i=1;i*i<=N;i++) {
        if(N%i == 0) {
            ans = min(ans, (i+N/i)*2);
        }
    }

    return ans;
}