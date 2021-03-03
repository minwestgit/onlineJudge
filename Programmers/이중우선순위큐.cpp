#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    deque<int> dq;
    for(string op : operations) {
        if(op[0] == 'I') {
            dq.push_back(stoi(op.substr(2)));
            sort(dq.begin(), dq.end());
        } else {
            if(dq.empty()) continue;
            if(op[2] == '1') {
                dq.pop_back();
            } else {
                dq.pop_front();
            }
        }
    }
    
    if(dq.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    } else {
        answer.push_back(dq.back());
        answer.push_back(dq.front());            
    }
    return answer;
}