#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> v;

int main(int argc, const char * argv[]) {

    cin >> n;

    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    int result = 0; // 총 그룹의 수
    int count = 0; // 현재 그룹에 포함된 모험가의 수

    for(int i=1;i<n;i++) {
        count++;
        if(count >= v[i]) {
            result++;
            count = 0;
        }
    }

    cout << result << endl;
}