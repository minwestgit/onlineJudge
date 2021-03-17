#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    sort(routes.begin(), routes.end());
    
    int car = routes[0][1];
    answer++;
    
    for(auto r : routes) {
        // 앞 차의 진출 지점과 다음 차량의 진입 지점 비교
        // 두 차의 경로가 겹치지 않으면 카메라 추가
        if(car<r[0]) {
            answer++;
            car = r[1];
        }
        // 경로가 겹치면
        // 가장 먼저 나가는 차의 진출 지점을 저장
        else {
            car = min(car, r[1]);
        }
    }
    
    return answer;
}