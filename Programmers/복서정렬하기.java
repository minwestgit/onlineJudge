import java.util.*;
class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int n = weights.length;
        int[] answer = new int[n];
        List<Boxer> b = new ArrayList<>();
        for(int i=0;i<head2head.length;i++) {
            int winNum = 0, winCnt = 0, roundCnt = 0; // 이긴횟수, 자기보다무거운복서이긴횟수, 경기횟수
            for(int j=0;j<head2head[i].length();j++) {
                if(i==j) continue; // 자기 자신과의 경기는 pass
                // 경기를 진행하지 않은 경우도 pass
                if(head2head[i].charAt(j) == 'N') {
                    continue;
                }
                // 이긴 경우
                else if(head2head[i].charAt(j) == 'W') {
                    winNum += 1;
                    if(weights[i] < weights[j]) {
                        winCnt += 1;
                    }
                }
                roundCnt++;
            }
            double winPer = 0;
            if(roundCnt != 0) {
                winPer = (double) winNum/roundCnt*100;
            }
            Boxer tmp = new Boxer(i+1, weights[i], winCnt, winPer); // 선수별 경기정보 저장
            b.add(tmp);
        }
        Collections.sort(b);

        for(int i=0;i<n;i++) {
            answer[i] = b.get(i).idx;
        }
        return answer;
    }
    
    class Boxer implements Comparable<Boxer> {
        public int idx; // 선수 번호
        public int weight; // 몸무게
        public int winCnt; // 자기보다 무거운 복서 이긴 횟수
        public double winPer; // 승률

        public Boxer(int idx, int weight, int winCnt, double winPer) {
            this.idx = idx;
            this.weight = weight;
            this.winCnt = winCnt;
            this.winPer = winPer;
        }

        @Override
        public int compareTo(Boxer o) {
            if(o.winPer > winPer) return 1;
            else if(o.winPer < winPer) return -1;
            else {
                if(o.winCnt > winCnt) return 1;
                else if(o.winCnt < winCnt) return -1;
                else {
                    if(o.weight > weight) return 1;
                    else if(o.weight < weight) return -1;
                    else {
                        if(o.idx < idx) return 1;
                        else return -1;
                    }
                }
            }
        }
        
    }
}