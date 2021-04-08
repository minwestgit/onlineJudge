#include <vector>
#include <iostream>
#include<algorithm>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    arr.erase(unique(arr.begin(),arr.end()),arr.end());

    /* 
    ** 다른 풀이
    answer.push_back(arr[0]);
    for(int i=1;i<arr.size();i++) {
        if(arr[i-1] == arr[i]) continue;
        answer.push_back(arr[i]);
    }
    return answer;
    */
   
    return arr;
}