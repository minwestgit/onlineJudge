#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int left = 10, right = 12;
    
    for(int i=0;i<numbers.size();i++) {
    	// 왼쪽
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
            answer += "L";
            left = numbers[i];
        }
        // 오른쪽
        else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
            answer += "R";
            right = numbers[i];
        }
        // 가운데
        else {
            if(numbers[i] == 0) {
                numbers[i] = 11;
            }
            // 거리 계산
            int dl = abs(left-numbers[i])/3 + abs(left-numbers[i])%3;
            int dr = abs(right-numbers[i])/3 + abs(right-numbers[i])%3;
            // 왼손이 가까운 경우
            if(dl > dr) {
                answer += "R";
                right = numbers[i];
            }
            // 오른손이 가까운경우
            else if(dl < dr) {
                answer += "L";
                left = numbers[i];
            }
            // 같은 경우
            else {
                if(hand[0] == 'r') { // 오른손잡이
                    answer += "R";
                    right = numbers[i];
                }
                else { // 왼손잡이
                    answer += "L";
                    left = numbers[i];
                }
            }
        }
    }
    return answer;
}