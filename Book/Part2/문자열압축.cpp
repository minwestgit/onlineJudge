#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = s.size();
    for(int i=0;i<s.size()/2+1;i++) {
        string comp = "";
        string prev = s.substr(0, i);
        int cnt = 1;
        for(int j=i;j<s.size();j+=i) {
            if(prev == s.substr(j,i)) cnt += 1;
            else {
                if(cnt >= 2) comp += to_string(cnt) + prev;
                else comp + prev;
                prev = s.substr(j, i); // 다시 상태 초기화
                cnt = 1;
            }
        }
        if(cnt >= 2) comp += to_string(cnt) + prev;
        else comp + prev;

        answer = min(answer, (int) comp.size());
    }
    
    return answer;
}