#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

int solution(vector<vector<int> > board, vector<int> moves) {
    int answer = 0;
    stack<int> s;
    for(int i=0;i<moves.size();i++) {
        int tmp = moves[i] - 1;
        for(int j=0;j<board.size();j++) {
            if(board[j][tmp] == 0) continue;
            else {
            	// 인형이 하나도 쌓여있지 않거나 터뜨려지지 않는 경우
                if(s.empty() || s.top() != board[j][tmp]) {       
                    s.push(board[j][tmp]);
                }
                // 인형이 터뜨려지는 경우
                else {
                    s.pop();
                    answer += 2;
                }
                board[j][tmp] = 0;
                break;
            }
        }
    }
        
    return answer;
}