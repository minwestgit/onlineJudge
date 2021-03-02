#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;
    for(auto cloth : clothes) {
        m[cloth[1]]++; // 의상 종류 갯수 cnt
    }
        
    for(auto i = m.begin(); i != m.end(); i++) {
        answer *= (i->second+1); // 해당 의상 종류를 입지 않는 경우를 생각해 +1
    }
    return answer-1;
}