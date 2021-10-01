import java.util.*;
class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+2];
        Arrays.fill(student, 1);
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int l : lost) {
            student[l] -= 1;
        }
        for(int r : reserve) {
            student[r] += 1;
        }
        for(int l : lost) {
            if(student[l] != 0) continue;
            if(student[l-1] == 2) {
                student[l] += 1;
                student[l-1] -= 1;
            }
            else if(student[l+1] == 2) {
                student[l] += 1;
                student[l+1] -= 1;
            }
        }
        for(int i=1;i<=n;i++) {
            if(student[i] != 0) answer++;    
        }
        
        return answer;
    }
}