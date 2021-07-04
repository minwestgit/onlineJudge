#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
int arr[1000001];
vector<int> targets;

int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        arr[x] = 1; // 부품의 인덱스 기록
    }

    cin >> m;
    for(int i=0;i<m;i++) {
        int target;
        cin >> target;
        targets.push_back(target);
    }

    for(int i=0;i<m;i++) {
        if(arr[targets[i]] == 1) {
            cout << "yes" << ' ';
        }
        else {
            cout << "no" << ' ';
        }
    }

    return 0;
}