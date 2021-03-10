#include <string>
#include <vector>
#include <algorithm>
using namespace std;

// 오름차순 정렬을 위한 함수
bool cmp(char a, char b) {
    return a > b;
}

int solution(string numbers) {
    int answer = 0;
    sort(numbers.begin(), numbers.end(), cmp);
    int max = stoi(numbers);
    
    /**
     에라토스테네스의 체를 이용해 소수를 구함.
    **/
    bool chk[10000000] = {0, };
    chk[0] = chk[1] = 1; // 소수가 아닌 0, 1은 제외
    // 조각을 붙여 만들 수 있는 최대값까지의 수에 대해 소수 판별
    for(int i=2;i<=max;i++) {
        if(!chk[i]) {
            for(int j=i+i;j<=max;j+=i) {
                chk[j] = true;
            }
        }
    }
    
    vector<char> v;    
    vector<int> num;
    // 종이 조각 각각을 분리 
    for(int i=0;i<numbers.size();i++) {
        v.push_back(numbers[i]);
    }
    sort(v.begin(), v.end());

    // 순열을 통해 모든 숫자 만듦
    do {
        string tmp = "";
        for(int i=0;i<v.size();i++) {
            tmp.push_back(v[i]);
            num.push_back(stoi(tmp));
        }
    } while (next_permutation(v.begin(), v.end()));
    
    sort(num.begin(), num.end());
    num.erase(unique(num.begin(), num.end()), num.end()); // 중복 숫자 제거
    
    // 소수의 갯수 체크
    for(int i=0;i<num.size();i++) {
        if(!chk[num[i]]) {
            answer++;
        }
    }
    
    return answer;
}