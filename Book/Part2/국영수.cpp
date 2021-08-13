#include <iostream>
#include <vector>
#include <algorithm>

// 정렬
using namespace std;

struct Student {
    string name;
    int kor;
    int eng;
    int math;
};

bool cmp(Student a, Student b) {
    if (a.kor == b.kor && a.eng == b.eng && a.math == b.math) return a.name < b.name;
    if (a.kor == b.kor && a.eng == b.eng) return a.math > b.math;
    if (a.kor == b.kor) return a.eng < b.eng;
    return a.kor > b.kor;
}

int main(int argc, const char * argv[]) {
    int n;
    cin >> n;
    vector<Student> v(n);
    
    for(int i=0;i<n;i++) {
        cin >> v[i].name >> v[i].kor >> v[i].eng >> v[i].math;
    }

    sort(v.begin(), v.end(), cmp);
    
    for(int i=0;i<n;i++) {
        cout << v[i].name << endl;
    }
}