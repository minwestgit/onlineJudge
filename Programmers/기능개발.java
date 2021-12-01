import java.util.*;
class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++) {
            int job = (100-progresses[i])/speeds[i] + ((100-progresses[i])%speeds[i] != 0 ? 1 : 0); // 작업 기간
            // 기존 작업들보다 오래걸리면 지금 까지 작업한 기능 add
            if(!q.isEmpty() && job>q.peek()) {
                ans.add(q.size());
                q.clear();
            }
            q.add(job);
        }
        ans.add(q.size()); // 마지막에 남은 작업 처리
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}