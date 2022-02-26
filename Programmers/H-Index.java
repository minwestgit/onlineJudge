import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            // 해당 논문 인용 횟수 >= 해당 논문보다 인용 횟수가 크거나 같은 편수(정렬 상태이므로 length-i)
            if(citations[i] >= citations.length-i) {
                answer = citations.length - i;
                break;
            }
        }
        return answer;
    }
}