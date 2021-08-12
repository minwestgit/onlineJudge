#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

string s;
int sumLeft = 0, sumRight = 0;

int main(int argc, const char * argv[]) {
    cin >> s;

    // 왼쪽 부분의 합
    for (int i=0;i<s.size()/2;i++) {
        sumLeft += s[i]-'0';
    }

    // 오른쪽 부분의 합
    for (int i=s.size()/2;i<s.size();i++) {
        sumRight += s[i]-'0';
    }

    if(sumLeft == sumRight) {
        cout << "LUCKY" << endl;
    }
    else {
        cout << "READY" << endl;
    }

}