#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    vector<vector<bool>> chk(n+1, vector<bool> (n+1, false));

    // 경기 결과(이긴 사람) check
    for(int i=0;i<results.size();i++) {
        chk[results[i][0]][results[i][1]] = true;
    }

    for(int k=1;k<=n;k++) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                // i가 k이기고 k가 j이기면 i가 j 이긴 것
                // 즉, i->k 이고 k->j 이면 i->j
                if(chk[i][k] && chk[k][j]) {
                    chk[i][j] = true;
                }
            }
        }
    }

    for(int i=1;i<=n;i++) {
        int cnt = 0;
        for(int j=1;j<=n;j++) {
            // i가 j를 이기거나 j가 i를 이긴 경우 cnt 증가
            if(chk[i][j] || chk[j][i]) {
                cnt++;
            }
        }
        // cnt가 선수의 수보다 1 적으면
        // 모든 선수와의 승/패를 판단할 수 있으므로 순위를 매길 수 있다.
        if(cnt == n-1) {
            answer++;
        }
    }
    
    return answer;
}