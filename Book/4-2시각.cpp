#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//3이 포함되는지 check하는 함수
bool check(int h, int m, int s) {
    if(h%10 == 3 || m/10 == 3 || m%10 == 3 || s/10 == 3 || s%10 == 3)
        return true;
    return false;
}

int main(int argc, const char * argv[]) {
    
    int n, cnt;
    cin >> n;

    //경우의 수가 작으므로 모든 경우의 수 count
    for(int i=0;i<=n;i++) {
        for(int j=0;j<60;j++) {
            for(int k=0;k<60;k++) {
                if(check(i,j,k)) cnt++;
            }
        }
    }

    cout << cnt;

    return 0;
}