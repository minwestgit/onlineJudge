#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(vector<int> &A, int K) {
    vector<int> ans;
    int n = A.size();

	if(n == 0) return A;

    int tmp = K%n; // n배수 회전은 제자리이므로 K%n
	for(int i = 0 ; i < n ; i++){
        int idx = (n-tmp+i)%n; // A의 idx가 n을 벗어나면 안되므로 %n
        ans.push_back(A[idx]);
    }
    
    return ans;
}
