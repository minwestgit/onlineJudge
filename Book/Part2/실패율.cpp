#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(pair<double,int> &a, pair<double,int> &b) {
    // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저
    if(a.first == b.first) return a.second < b.second;
    else return a.first > b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> cnt(N+1);
    vector<pair<double, int>> fail;
    
    // 스테이지별 도달한 플레이어의 수 계산
    for(int i=0;i<stages.size();i++) {
        cnt[stages[i]]++;
    }
    
    int sum = stages.size();
    for(int i=1;i<=N;i++) {
    	// 스테이지에 도달한 유저가 없는 경우 실패율 0
        if(cnt[i] == 0) {
            fail.push_back({0, i});
        }
        // 스테이지에 도달한 유저가 있는 경우 실패율 계산 
        else {
            double tmp = (double) cnt[i]/sum;
            fail.push_back({tmp, i});
        }
        sum -= cnt[i]; // 스테이지에 도달한 플레이어 수 계산
    }
    sort(fail.begin(), fail.end(), cmp); // 실패율 내림차순 정렬
    for(int i=0;i<fail.size();i++) {
        answer.push_back(fail[i].second);
    }
    return answer;
}