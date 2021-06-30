#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<string,int> a, pair<string,int> b) {
    return a.second > b.second;
}

int main(int argc, const char * argv[]) {
    
    int n;
    cin >> n;
    vector< pair<string,int> > v(n);

    for(int i=0;i<n;i++) {
        string name;
        int score;
        cin >> name >> score;
        v.push_back(make_pair(name, score));
    }

    sort(v.begin(), v.end(), cmp);

    for(int i=0;i<n;i++) {
        cout << v[i].first << ' '; 
    }

    return 0;
}