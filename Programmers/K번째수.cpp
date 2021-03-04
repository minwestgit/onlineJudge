#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(int i=0;i<commands.size();i++){
        int n = commands[i][0] - 1;
        int m = commands[i][1] - 1;
        vector<int> temp;
        for(int j=n;j<=m;j++){
            temp.push_back(array[j]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[commands[i][2]-1]);
    }
    
    return answer;
}