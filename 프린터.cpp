#include <string>
#include <vector>
#include <queue>

using namespace std;

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int,int>> q;
    priority_queue<int> pq; // 중요도 높은 문서를 찾기 위한 우선순위 큐

    for(int i=0;i<priorities.size();i++) {
        q.push(make_pair(priorities[i],i));
        pq.push(priorities[i]);
    }

    while(!q.empty()) {
        int num = q.front().first;
        int order = q.front().second;
        q.pop();

        // 중요도 높은 문서가 큐의 제일 앞 문서와 같으면 인쇄
        if(num == pq.top()) {
            pq.pop();
            answer++;
            // 인쇄 요청한 문서면 종료
            if(order == location) {
                break;
            }
        } 
        // 인쇄 대기목록에 중요도가 더 높은 문서가 있으면
        // 대기목록의 가장 마지막에 push
        else {
            q.push(make_pair(num,order));
        }    
    }
    
    return answer;
}