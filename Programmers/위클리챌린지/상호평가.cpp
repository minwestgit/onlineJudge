#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string calcAvg(int sum, int n) {
    int avg = sum/n;
    string ans;
    
    // 학점 계산
    if(avg>=90) ans = 'A';
    else if(avg>=80) ans = 'B';
    else if(avg>=70) ans = 'C';
    else if(avg>=50) ans = 'D';
    else ans = 'F';
    
    return ans;
}

string solution(vector<vector<int>> scores) {
    string answer = "";
    vector<int> tmp; // 학생별 점수 저장
    int n = scores.size();
    
    for(int i=0;i<n;i++) {
        int sum = 0; // 학생별 점수의 총 합
        int me = 0; // 자기 자신에게 준 점수
        tmp.clear();
        for(int j=0;j<n;j++) {
            tmp.push_back(scores[j][i]);
            if(i == j) {
                me = scores[j][i];
            }
            sum += scores[j][i];
        }
        sort(tmp.begin(), tmp.end()); // 최고점, 최저점 구하기 위해 정렬

        // 자기 자신을 평가한 점수가 유일한 최고점인 경우
        if(me == tmp[0] && me != tmp[1]) 
            answer += calcAvg(sum-me, n-1);
        // 자기 자신을 평가한 점수가 유일한 최저점인 경우
        else if(me == tmp[n-1] && me != tmp[n-2]) 
            answer += calcAvg(sum-me, n-1);
        else 
            answer += calcAvg(sum, n);

    }
    return answer;
}