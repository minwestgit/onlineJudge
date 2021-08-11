#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<int> arr;
vector<int> targets;

// 이진 탐색 소스코드(재귀 함수)
int binarySearch(vector<int> &arr, int target, int start, int end) {
    if(start>end) {
        return -1;
    }
    int mid = (start+end)/2;
    if(arr[mid] == target) {
        return mid;
    }
    else if(arr[mid] > target) {
        return binarySearch(arr, target, start, mid-1);
    }
    else {
        return binarySearch(arr, target, mid+1, end);
    }
}

int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i=0;i<n;i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }

    cin >> m;
    for(int i=0;i<m;i++) {
        int target;
        cin >> target;
        targets.push_back(target);
    }

    for(int i=0;i<m;i++) {
        if(binarySearch(arr, targets[i], 0, n-1) != -1) {
            cout << "yes" << ' ';
        }
        else {
            cout << "no" << ' ';
        }
    }

    return 0;
}