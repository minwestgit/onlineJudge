import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N+2];
        Arrays.fill(cnt,0);
        // stage별 멈춰있는 사용자의 수 count
        for(int i=0;i<stages.length;i++) {
            cnt[stages[i]]++;
        }
        
        int total = stages.length;
        List<Stage> st = new ArrayList<>();
        // stage별 실패율 List에 추가
        for(int i=1;i<=N;i++) {
            double fail = (double) cnt[i]/total;
            Stage s = new Stage(i, fail);
            st.add(s);
            total -= cnt[i];
        }
        
        // 실패율 내림차순 정렬
        Collections.sort(st, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                 if (s1.fail > s2.fail) {
                    return -1;
                } else if (s1.fail < s2.fail) {
                    return 1;
                }
                return 0;
            }
        });
		
        int[] answer = new int[N];
        for(int i=0;i<N;i++) {
            answer[i] = st.get(i).idx;
        }
        return answer;
    }

    class Stage implements Comparator<Stage> {
        public int idx;
        public double fail;

        public Stage(int idx, double fail) {
            this.idx = idx;
            this.fail = fail;
        }

        @Override
        public int compare(Stage s1, Stage s2) {
            if(s1.fail > s2.fail) return 1;
            if(s1.fail < s2.fail) return -1;
            return 0;
        }
    }
}