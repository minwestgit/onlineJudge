#include <algorithm>
#include <stack>
#include <iostream>
using namespace std;

int solution(string &S) {
    int n = S.size();
    stack<int> s;
    for(int i=0;i<n;i++) {
        if(S[i] == '{' || S[i] == '[' || S[i] == '(') {
            s.push(S[i]);
        }
        else {
            if(s.empty()) return 0;
            if(S[i] == '}' && s.top() == '{') {
                s.pop();
            }
            else if(S[i] == ']' && s.top() == '[') {
                s.pop();
            }
            else if(S[i] == ')' && s.top() == '(') {
                s.pop();
            }
        }
    }

    if(s.empty()) return 1;
    return 0;
}