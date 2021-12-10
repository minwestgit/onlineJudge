class 타겟넘버 {
    public static int answer = 0;
    public void getTargetCnt(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        getTargetCnt(numbers, index+1, sum+numbers[index], target);
        getTargetCnt(numbers, index+1, sum-numbers[index], target);
    }
    public int solution(int[] numbers, int target) {
        getTargetCnt(numbers, 0, 0, target);
        return answer;
    }
}