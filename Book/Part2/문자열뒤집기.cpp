#include <iostream>
#include <algorithm>
#include <vector>

// 그리디
using namespace std;

string str;

int zeroCnt = 0;
int oneCnt = 0;

int main() {
    cin >> str;

    if(str[0] == '0') zeroCnt++;
    else oneCnt++;

    // 숫자가 바뀌는 순간을 체크
    for(int i=0;i<str.size()-1;i++) {
        if(str[i] != str[i+1]) {
            if(str[i+1] == '0') zeroCnt++;
            else oneCnt++;
        }
    }

    cout << min(zeroCnt, oneCnt);
    
}