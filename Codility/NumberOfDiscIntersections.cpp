#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    vector<long long> lower, upper;
    int n = A.size();
    // 각 디스크의 시작, 끝 구하기
    for(int i=0;i<n;i++) {
        lower.push_back((long long) i-A[i]);
        upper.push_back((long long) i+A[i]);
    }
    sort(lower.begin(), lower.end());

    int cnt = 0;
    for(int i=0;i<n-1;i++) {
        for(int j=i+1;j<n;j++) {
            if(cnt > 10000000)
            	return -1;
            // 디스크가 아예 교차하지 않으면 break
            if(lower[j] > upper[i])
            	break;
            // lower 기준 디스크 교차 여부 체크
            if(lower[j] >= lower[i] && lower[j] <= upper[i]) 
            	cnt++;
        }
    }
    return cnt;
}