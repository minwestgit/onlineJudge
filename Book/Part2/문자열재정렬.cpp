#include <iostream>
#include <algorithm>
#include <vector>

// 구현
using namespace std;

string s;
vector<char> res;
int sum = 0;

int main(int argc, const char * argv[]) {

    cin >> s;

    for(int i=0;i<s.size();i++) {
        // 알파벳 대문자
        // isalpha(s[i])도 가능
        if(s[i] > 64 && s[i] < 97) {
            res.push_back(s[i]);
        }
        // 숫자
        else {
            sum += s[i] - '0';
        }
    }

    sort(res.begin(), res.end());

    for(int i=0;i<res.size();i++) {
        cout << res[i];
    }

    // 숫자가 존재하면 숫자 더한 값 출력
    if (sum != 0) { 
        cout << sum << endl;
    }

}