import java.util.*;
class Solution {
    public static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        String[] num = numbers.split("");
        boolean visited[] = new boolean[numbers.length()];
        dfs(num, visited, ""); // 가능한 모든 수 만들기
        
        // 소수인지 체크
        for(Integer s : set) {
            if(s < 2) continue;
            boolean check = true;
            for(int i = 2; i*i <= s; i++) {
                if(s%i == 0) {
                    check = false;
                    break;
                }
            }
            if(check) answer += 1;
        }
        
        return answer;
    }
    
    public void dfs(String[] num, boolean[] visited, String str) {
        for(int i = 0; i < num.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            set.add(Integer.parseInt(str+num[i]));
            dfs(num, visited, str+num[i]);
            visited[i] = false;
        }
    }
}