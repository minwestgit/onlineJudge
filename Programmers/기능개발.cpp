#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    
    // 기능별 작업 속도 계산
    for(int i=0;i<progresses.size();i++) {
        int speed = (100-progresses[i])/speeds[i];
        if((100-progresses[i])%speeds[i] != 0) {
            speed++;
        }
        q.push(speed);
    }
    
    int first = q.front();
    int cnt = 0;
    while(!q.empty()) {
        // 같이 배포할 수 있는 기능 수 count
        if(first >= q.front()) {
            cnt++;
            q.pop();
        } else {
            answer.push_back(cnt);
            cnt = 0;
            first = q.front();
        }
    }

    // 마지막 cnt 추가
    if(cnt != 0) {
        answer.push_back(cnt);
    }
    
    return answer;
}