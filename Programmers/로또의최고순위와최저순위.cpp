#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int ansCnt = 0, zeroCnt = 0;
    for(auto lotto : lottos) {
    	// 0 개수 count
        if(lotto == 0) {
            zeroCnt++;
        }
        // 맞은 개수 count
        else if(find(win_nums.begin(), win_nums.end(), lotto) != win_nums.end()) {
            ansCnt++;
        }
    }
    
    int min = ansCnt; // 최소 당첨 개수
    int max = ansCnt + zeroCnt; // 최대 당첨 개수
    // min, max 둘 다 하나도 맞지 않은 경우를 고려해야 함
    if(max == 0) answer.push_back(6);
    else answer.push_back(6-max+1);  
    if(min == 0) answer.push_back(6);
    else answer.push_back(6-min+1);
    
    return answer;
}