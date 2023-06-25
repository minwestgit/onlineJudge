import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        // String[] answer = new String[plans.length];
        List<String> answer = new ArrayList<>();
        List<Plan> planList = new ArrayList<>();
        Stack<Plan> stop = new Stack<>();
        
        for(String[] plan: plans) {
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            int playtime = Integer.parseInt(plan[2]);
            planList.add(new Plan(plan[0], start, playtime));
        }
        Collections.sort(planList, (a, b) -> a.start - b.start);
        // for(int i = 0; i < planList.size(); i++) {
        //     System.out.println(planList.get(i).subject);
        // }
        
        for(int i = 0; i < planList.size()-1; i++) {
            Plan now = planList.get(i);
            Plan next = planList.get(i+1);
            int nowEndTime = now.start + now.playtime;
            int diffTime = next.start - nowEndTime; //plan 후 남은 시간
            //현재 계획이 아직 안 끝났다면
            if(diffTime < 0) {
                stop.push(new Plan(now.subject, now.start, Math.abs(diffTime)));
            }
            else {
                answer.add(now.subject);
                //과제를 끝냈을 때, 잠시 멈춘 과제가 있다면
                //새로 시작해야 하는 과제 포함 X
                while(!stop.isEmpty() && diffTime > 0){
                    Plan stopPlan = stop.peek();
                    //멈춘 과제 끝낼 수 있는 경우
                    if(stopPlan.playtime <= diffTime){
                        answer.add(stopPlan.subject);
                        stop.pop();
                        diffTime -= stopPlan.playtime; //다음 멈춘 과제를 위해 diffTime 처리
                    }
                    //끝낼 수 없는 경우 시간을 다시 계산해 stop에 push 후 종료
                    else {
                        Plan leftPlan = stop.pop();
                        stop.push(new Plan(leftPlan.subject, leftPlan.start, leftPlan.playtime-diffTime));
                        break;
                    }   
                }
                
            }
        }
        
        answer.add(planList.get(planList.size()-1).subject); // last plan
        //남은 멈춘 plan
        while(!stop.isEmpty()) {
            answer.add(stop.pop().subject);
        }
        
        
        return answer.toArray(new String[answer.size()]);

    }
}

class Plan {
    String subject;
    int start;
    int playtime;
    
    public Plan(String subject, int start, int playtime) {
        this.subject = subject;
        this.start = start;
        this.playtime = playtime;
    }
}