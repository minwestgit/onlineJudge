#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> answer, temp;
bool visited[10001] = {0, };

void dfs(vector<vector<string>> tickets, string start, int cnt) {
    temp.push_back(start);
    
    // 모든 도시를 방문했으면 종료
    // 첫 answer가 알파벳 순서가 앞서는 경로
    if(cnt == tickets.size() && answer.empty()) {
        answer = temp;
        return;
    }
    
    for(int i=0;i<tickets.size();i++) {
        // 방문여부 체크
        if(start == tickets[i][0] && !visited[i]) {
            visited[i] = true;
            dfs(tickets, tickets[i][1], cnt+1);
            visited[i] = false;
        }
    }  
    temp.pop_back();  
}
vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    dfs(tickets, "ICN", 0);
    return answer;
}