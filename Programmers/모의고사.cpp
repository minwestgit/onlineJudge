#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

vector<vector<int>> ans = { {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
vector<int> score = {0,0,0};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    // 점수 계산
    for(int i=0;i<answers.size();i++){
        if(ans[0][i%5] == answers[i]) score[0]++;
        if(ans[1][i%8] == answers[i]) score[1]++;
        if(ans[2][i%10] == answers[i]) score[2]++;
    }
    
    int max_score = *max_element(score.begin(), score.end()); // 이 과정에서 오름차순 정렬됨.
    
    for(int i=0;i<3;i++){
        if(max_score == score[i]){
            answer.push_back(i+1);
        }
    }
    return answer;
}