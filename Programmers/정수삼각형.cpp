#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    int d[501][501];
    answer= d[0][0] = triangle[0][0]; // 꼭대기 숫자
    
    for(int i=1;i<triangle.size();i++) {
        for(int j=0;j<triangle[i].size();j++) {
            if(j==0) // 가장 왼쪽 수
                d[i][j] = d[i-1][j] + triangle[i][j];
            else if(j==i) // 가장 오른쪽 수
                d[i][j] = d[i-1][j-1] + triangle[i][j];
            else { // 그 외에는 왼쪽, 오른쪽 중 큰 값 더해줌
                int tmp = max(d[i-1][j], d[i-1][j-1]);
                d[i][j] = tmp + triangle[i][j];
            }
            // 마지막 줄에서 가장 큰 값이 정답
            if(i==triangle.size()-1)
                answer = max(answer, d[i][j]);
        }
    }
    return answer;
}