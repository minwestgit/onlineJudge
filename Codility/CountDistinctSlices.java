class Solution {
    public int solution(int M, int[] A) {
        boolean chk[] = new boolean[M+1];
        int ans = 0, right = 0;
        int n = A.length;
        
        for(int left=0;left<n;left++) {
            while(right < A.length && !chk[A[right]]) {
                ans += (right-left+1);
                chk[A[right]] = true;
                right++;
                if(ans >= 1000000000) {
                    return 1000000000;
                }
            }

            chk[A[left]] = false;

            if(ans >= 1000000000) {
                return 1000000000;
            }
        }

        return ans;
    }
}