#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char moveTypes[4] = {'L', 'R', 'U', 'D'};

int main(int argc, const char * argv[]) {
    int n;
    int x = 1, y = 1;
    string plans;

    cin >> n;
    getline(cin, plans);

    for(int i=0;i<plans.size();i++) {
        char plan = plans[i]; // 한 문자씩 이동
        
        int nx = -1, ny = -1;
        for(int j=0;j<4;j++) {
            if(plan == moveTypes[j]) {
                nx = x+dx[j];
                ny = y+dy[j];
            }
        }

        // 공간을 벗어나면 무시
        if(nx<1 || nx>n || ny<1 || ny>n) {
            continue;
        }
        x = nx;
        y = ny;
    }

    cout << x << ' ' << y << endl;
    return 0;
}