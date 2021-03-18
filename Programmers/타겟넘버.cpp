#include <string>
#include <vector>

using namespace std;

int answer = 0;

void calc(vector<int> numbers, int index, int sum, int target) {
    if(index == numbers.size()) {
        if(sum == target) answer++;
        return;
    }
    calc(numbers, index+1, sum+numbers[index], target);
    calc(numbers, index+1, sum-numbers[index], target);
}

int solution(vector<int> numbers, int target) {
    calc(numbers, 0, 0, target);
    return answer;
}