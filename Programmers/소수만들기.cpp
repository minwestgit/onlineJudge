#include <vector>
#include <iostream>
using namespace std;
bool chk[1001];

bool isPrime(int n) {
    if(n<2) {
	    return false;
	}
    for(int i=2;i*i<=n;i++) {
        if(n%i==0) {
            return false;
        }
    }   
    return true;
}

int solution(vector<int> nums) {
    int answer = 0;
    for(int i=0;i<nums.size()-2;i++) {
        for(int j=i+1;j<nums.size()-1;j++) {
            for(int k=j+1;k<nums.size();k++) {
                int tmp = nums[i]+nums[j]+nums[k];
                if(isPrime(tmp) == true) {
                    answer++;
                }
            }
        }
    }

    return answer;
}