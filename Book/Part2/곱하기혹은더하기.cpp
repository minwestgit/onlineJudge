#include <iostream>
#include <vector>
#include <algorithm>

// 그리디
using namespace std;

int main(int argc, const char * argv[]) {

    string s;
    cin >> s;
    
    int res = 0;
    for(int i=0;i<s.size();i++) {
        int num = s[i] - '0'; // 문자->숫자
        if(num == 0 || res == 0) {
            res += num;
        }
        else {
            res *= num;
        }
    }

    cout << res << endl;
}