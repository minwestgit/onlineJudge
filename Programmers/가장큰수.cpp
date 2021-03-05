#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 순서 배치를 위한 함수
bool cmp(string a, string b) {
    return (a+b) > (b+a);
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> tempNum;
    for(auto num : numbers) {
        tempNum.push_back(to_string(num));
    }
    sort(tempNum.begin(), tempNum.end(), cmp);
    for(auto tmp : tempNum) {
        answer += tmp;
    }
    // 0인 경우
    if(answer[0] == '0') {
        answer = '0';
    }
    return answer;
}