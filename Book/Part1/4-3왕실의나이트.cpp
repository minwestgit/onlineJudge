#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int dx[] = {-2, -2, 2, 2, -1, -1, 1, 1};
int dy[] = {-1, 1, -1, 1, -2, 2, -2, 2};
 
int main(int argc, const char * argv[]) {
    string str;
    cin >> str;
    int x = str[1] - '0';
    int y = str[0] - 'a' + 1;

    int cnt = 0;
    for(int i=0;i<8;i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];

        if(nx>0 && nx<=8 && ny>0 && ny<=8) {
            cnt++;
        }
    }

    cout << cnt << endl;
    
    return 0;
}