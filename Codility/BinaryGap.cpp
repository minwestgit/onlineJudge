#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int solution(int N) {
    stack<int> s;
    // stack의 속성을 이용해 10진수->2진수 변환
    while(N > 0) {
        int rem = N%2;
        s.push(rem);
        N /= 2;
    }

    int cnt = 0, ans = 0;;
    int size = s.size();
    for(int i=0;i<size;i++) {
    	// 값을 하나씩 꺼내 BinaryGap 계산
        int t = s.top();
        s.pop();
        if(t == 0) {
            cnt++;
        }
        else {
            if(ans < cnt) {
                ans = cnt;
            }
            cnt = 0;
        }
    }
    
    return ans;
}
