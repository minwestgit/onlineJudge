#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int n = A.size();
    if(n == 1) return 0; // 원소가 1개이면 당연히 dominator이므로 return

    // 같은 원소의 갯수를 세기 위해 벡터를 복사해 정렬
    vector<int> tmp;
    for(int i=0;i<n;i++) {
        tmp.push_back(A[i]);
    }
    sort(tmp.begin(), tmp.end());

    int ans = 1e9; // 최댓값 이상으로 초기화

    int cnt = 1;
    for(int i=1;i<n;i++) {
        // 바로 전 원소와 값이 같다면 count+1
        if(tmp[i] == tmp[i-1]) {
            cnt++;
            // 마지막 원소가 전 원소가 같은 경우를 따로 체크해줘야함.
            // ex) 0 0 1 1 1
            if(i == n-1) {
                if(cnt > n/2) {
                    ans = tmp[i-1];
                    break;
                }
            }
        }
        // 바로 전 원소와 같지 않다면 dominator인지 체크
        else {
            if(cnt > n/2) {
                ans = tmp[i-1]; // dominator 값 저장
                break;
            }
            cnt = 1;
        }
    }

    // dominator 값과 같은 원소가 존재하는 위치를 return
    for(int i=0;i<n;i++) {
        if(A[i] == ans) {
            return i;
        }
    }
    return -1;
}
