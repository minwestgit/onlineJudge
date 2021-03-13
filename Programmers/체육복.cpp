#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> student(n+1, 1);
    // 체육복을 도난당했으면 -1
    for(auto l : lost){
        student[l] -= 1;
    }
    // 여벌의 체육복을 가져왔으면 +1
    for(auto r : reserve){
        student[r] += 1;
    }
    
    // 체육복 빌려주기
    for(int i=0;i<lost.size();i++){
        if(student[lost[i]] != 0)
            continue;
        
        if(student[lost[i]-1] == 2){
            student[lost[i]] = 1;
            student[lost[i]-1] =1;
        }
        else if(student[lost[i]+1] == 2){
            student[lost[i]] = 1;
            student[lost[i]+1] =1;
        }    
    }
  
    for(int i=1;i<=n;i++){
        if(student[i] != 0){
            answer++;
        }
    }
    
    return answer;
}
