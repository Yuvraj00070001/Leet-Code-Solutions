class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i <= n - firstLen; i++) {

            int firstSum = 0;
            for (int j = i; j < i + firstLen; j++) {
                firstSum += nums[j];
            }

            for (int k = 0; k <= n - secondLen; k++) {

                // Check overlap
                if (k + secondLen <= i || k >= i + firstLen) {

                    int secondSum = 0;
                    for (int l = k; l < k + secondLen; l++) {
                        secondSum += nums[l];
                    }

                    ans = Math.max(ans, firstSum + secondSum);
                }
            }
        }

        return ans;
    }
}