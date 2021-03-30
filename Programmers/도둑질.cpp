#include <string>
#include <vector>

using namespace std;

int solution(vector<int> money) {
    int answer = 0;
    int dp1[1000010];
    int dp2[1000010];
    
    // 첫 번째 집을 터는 경우
    dp1[0] = dp1[1] = money[0];
    
    for(int i=2;i<=money.size();i++) {
        dp1[i] = max(dp1[i-2]+money[i], dp1[i-1]);
    }
    
    // 첫 번째를 털지 않고, 두 번째 집부터 터는 경우
    dp2[0] = 0;
    dp2[1] = money[1];
    
    for(int i=2;i<money.size();i++) {
        dp2[i] = max(dp2[i-2]+money[i], dp2[i-1]);
    }
    
    // 둘 중 큰 값이 정답
    answer = max(dp1[money.size()-2], dp2[money.size()-1]);
    return answer;
}