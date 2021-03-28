#include <string>
#include <vector>

using namespace std;

int minCnt = 9;

void dfs(int N, int number, int cnt, int num) {
     // N 사용횟수가 8번 초과하면 return
    if(cnt > 8)
        return;

    // 최솟값 계산
    if(number == num) {
        if(minCnt > cnt) minCnt = cnt;
        return;
    }
    
    int tmp = 0;
    // 최대 N 사용횟수만큼 반복
    for(int i=1;i<=8;i++) {
        tmp = tmp*10 + N;
        dfs(N, number, cnt+i, num+tmp);
        dfs(N, number, cnt+i, num-tmp);
        if(num != 0) {
            dfs(N, number, cnt+i, num*tmp);
            dfs(N, number, cnt+i, num/tmp);
        }
    }
}

int solution(int N, int number) {
    int answer = 0;
    dfs(N, number, 0, 0);
    if(minCnt > 8) answer = -1;
    else answer = minCnt;
    return answer;
}
