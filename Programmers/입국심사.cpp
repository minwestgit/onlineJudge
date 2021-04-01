#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long start = 1; // 최소 시간
    long long end = (long long) *max_element(times.begin(), times.end()) * n; // 최대 시간
    long long mid;
    
    while(start<=end) {
        mid = (start+end)/2; // 평균 시간
        long long p = 0;
        
        // 심사 받을 수 있는 사람 수 구하기
        for(auto time : times) {
            p += mid/time;
        }
        
        // 이분 탐색
        if(p<n) start = mid+1;
        else {
            end = mid-1;
            answer = mid;
        }
    }
    return answer;
}