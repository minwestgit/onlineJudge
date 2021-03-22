#include <string>
#include <vector>

using namespace std;

bool chk[101];
int answer = 100;

void dfs(string begin, string target, vector<string> words, int cnt) {
    // target으로 변환되면 가장 짧은 과정인지 비교
    if(target == begin) {
        if(answer > cnt) answer = cnt;
        return;
    }
    
    // 모든 단어 비교
    for(int i=0;i<words.size();i++) {
        int count = 0;
        for(int j=0;j<words[i].size();j++) {
            // 현재 begin 단어와 몇 개의 알파벳이 다른지 count
            if(begin[j] != words[i][j]) count++;
            if(count == 2) break;
        }
        // 한 개의 알파벳만 다른 경우 단계 이동 가능
        if(count == 1) {
            if(chk[i] == false) {
                chk[i] = true;
                dfs(words[i], target, words, cnt+1);
                chk[i] = false;
            }
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    dfs(begin, target, words, 0);
    if(answer == 100) return 0; // 변환할 수 없는 경우
    return answer;
}