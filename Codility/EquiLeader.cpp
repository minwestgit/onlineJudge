#include <algorithm>
#include <map>
#include <vector>

using namespace std;

int solution(vector<int> &A) {
    int n = A.size();
    int ans = 0;
    int leader, max = 0;
    map<int, int> m; 

    if(n == 1){
        return 0;
    }

    // leader 구하기
    for(int i=0;i<n;i++){
        if(m.find(A[i]) != m.end()){
            m[A[i]] += 1; 
        }else{
            m.insert(pair<int, int>(A[i], 1));
        }
		
        if(max < m[A[i]]){
            max = m[A[i]]; // leader의 cnt수
            leader = A[i]; // leader
        }
    }
	
    // leader가 존재하지 않는 경우
    if(max < n/2) {
        return 0;
    }

    // 4 / 3 4 4 4 2 라면 leftCnt 1 RightCnt 3
    int leftCnt = 0;
    int rightCnt = max;
    for(int i=0;i<n;i++) {
        if(A[i] == leader) {
            leftCnt++;
            rightCnt--;
        }
        // 둘 다 leader인지 check
        if(leftCnt > (i+1)/2 && rightCnt > (n-i-1)/2) {
            ans++;
        }
    }

    return ans;
}