class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i=total/2;i>0;i--) {
            if(total%i == 0) {
                int w = i;
                int h = total/w;
                if((w-2)*(h-2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
        return answer;
    }
}