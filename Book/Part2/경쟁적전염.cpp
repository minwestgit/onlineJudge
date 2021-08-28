#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dx[] = {1, -1, 0 ,0};
int dy[] = {0, 0, 1, -1};

int n, k;
int map[201][201];
int s, x, y;

struct Virus{
	int virus;
	int x;
	int y;

    Virus(int virus, int x, int y) {
        this->virus = virus;
        this->x = x;
        this->y = y;
    }
};
vector<Virus> v;

int main(int argc, const char * argv[]) {
    cin >> n >> k;
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            cin >> map[i][j];
            if(map[i][j] > 0) {
                v.push_back({ map[i][j], i, j });
            }
        }
    }
    cin >> s >> x >> y;

    sort(v.begin(), v.end());
    queue<Virus> q;

    for(int i=0;i<v.size();i++) {
        q.push(v[i]);
    }

    int second = 0;
    while(!q.empty()) {
        Virus vir = q.front();
        q.pop();
        if(second == s) break;
        for(int k=0;k<4;k++) {
            int nx = vir.x + dx[k];
            int ny = vir.y + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny] == 0) {
                map[nx][ny] = vir.virus;
                q.push(Virus(vir.virus, nx, ny));
            }
        }
        second++;
    }

    cout << map[x-1][y-1] << endl;
}