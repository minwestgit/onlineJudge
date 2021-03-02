#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for(int i=0;i<scoville.size();i++) {
        pq.push(scoville[i]);
    }
    
    while(pq.top()<K) {
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if(pq.size()==1) {
            answer=-1;
            break;
        }
        
        int x = pq.top();
        pq.pop();
        int y = pq.top();
        pq.pop();
        pq.push(x+2*y);
        answer++;
    }
    
    return answer;
}