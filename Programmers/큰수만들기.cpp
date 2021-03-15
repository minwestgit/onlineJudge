#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int index = -1;
    int n = number.length();
    for(int i=0;i<n-k;i++) {
        char max = 0;
        // 만들 수의 길이를 고려해
        // k+i번째까지 중 최댓값을 찾아 answer에 추가
        for(int j=index+1;j<=k+i;j++) {
            if(max<number[j]) {
                index = j;
                max = number[j];
            }
        }
        answer += max;
    }
    return answer;
}