public class 큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        int index = -1;
        int n = number.length();
        for(int i=0;i<n-k;i++) {
            char max = 0;
            for(int j=index+1;j<=k+i;j++) {
                if(max<number.charAt(j)) {
                    index = j;
                    max = number.charAt(j);
                }
            }
            answer += max;
        }
        return answer;
    }
}