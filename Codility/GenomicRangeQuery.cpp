#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> ans;

vector<int> solution(string &S, vector<int> &P, vector<int> &Q) {
    vector<int> cnt(4);
    vector<vector<int> > accm;

    fill(cnt.begin(), cnt.end(), 0);
    accm.push_back( {0, 0, 0, 0 }); // P[i] = 0인 경우를 고려해 초기 값 넣어줌.

    // A, C, G, T 의 누적 카운트를 저장
    for(int i=0;i<S.size();i++) {
        if(S[i] == 'A') cnt[0]++;
        else if(S[i] == 'C') cnt[1]++;
        else if(S[i] == 'G') cnt[2]++;
        else cnt[3]++;
        accm.push_back(cnt);
    }

    for(int i=0;i<P.size();i++) {
        for(int j=0;j<4;j++) {
            int num = accm[Q[i]+1][j] - accm[P[i]][j];
            if(num > 0) {
                ans.push_back(j+1);
                break;
            }
        }
    }

    return ans;
}