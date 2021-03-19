#include <string>
#include <vector>

using namespace std;
bool check[201] = {0,};

void dfs(int n, int m, vector<vector<int>> computers) {
    check[m] = true;
    for(int i=0;i<n;i++) {
        // 해당 컴퓨터와 연결되어있고 아직 네트워크에 포함되지 않은 컴퓨터 탐색
        if(computers[m][i] == true && check[i] == false) {
            dfs(n, i, computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0;i<n;i++) {
        // 네트워크에 포함되지 않은 컴퓨터 탐색
        if(check[i] == false) {
            answer++;
            dfs(n, i, computers);
        }
    }
    return answer;
}