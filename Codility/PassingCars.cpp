#include <algorithm>

int solution(vector<int> &A) {
    int oneCnt = 0;
    int answer = 0;
    for(int i=0;i<A.size();i++) {
        if(A[i] == 1) oneCnt++;
    }

    for(int i=0;i<A.size();i++) {
        if(A[i] == 0) {
            answer += oneCnt;
            if(answer > 1000000000 ) return -1;
        }
        else {
            oneCnt--;
        }
    }
    return answer;
}