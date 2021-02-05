#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int sum = 0, idx = 0;
    queue<int> q;
    
    while(1) {
        answer++;
        // 큐의 길이와 다리의 길이가 같으면 트럭이 도착한 것
        if(q.size() == bridge_length) {
            sum -= q.front();
            q.pop();
        }

        // 다음 트럭이 다리를 지나갈 수 있으면
        // 다음 트럭의 무게를 더한 합이 다리의 무게보다 작으면, 트럭 push
        if(sum + truck_weights[idx] <= weight) {
            // 마지막 트럭이면 마지막 트럭의 길이만큼 시간을 더해준다.
            if(idx == truck_weights.size()-1) {
                answer += bridge_length;
                break;
            }
            q.push(truck_weights[idx]);
            sum += truck_weights[idx];
            idx++;
        }
        // 다음 트럭의 무게를 더한 합이 다리의 무게보다 크면 0을 push해
        // 트럭의 도착 시간을 맞춰준다.
        else {
            q.push(0);
        }
    }
    
    return answer;
}