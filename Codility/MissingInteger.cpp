#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int ans = 1;
    
    // 정렬 & 중복제거
    sort(A.begin(), A.end());
    A.erase(unique(A.begin(), A.end()), A.end());
    
    for(int i=0;i<A.size();i++){
        if(ans == A[i])
            ans++;
        
    }
    return ans;
}