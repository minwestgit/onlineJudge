#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int start = 0;
    int end = people.size()-1;
    sort(people.begin(), people.end());

    while(start<=end) {
        // 가장 무거운 사람과 가벼운 사람이 같이 타는 것이 효율적
        if(people[start]+people[end] <= limit) {
            start++;
            end--;
        }
        // 두 사람의 합이 무게제한을 초과한다면
        // 무거운 사람 혼자 태움
        else {
            end--;
        }
        answer++;
    }
    return answer;
}