class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {

        long MOD = 1_000_000_007;

        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long maxSum = kadane(arr, k == 1 ? 1 : 2);

        if (k > 1 && totalSum > 0) {
            maxSum += (k - 2) * totalSum;
        }

        return (int) (maxSum % MOD);
    }

    private long kadane(int[] arr, int times) {

        long current = 0;
        long max = 0;

        int n = arr.length;

        for (int i = 0; i < n * times; i++) {
            current = Math.max(0, current + arr[i % n]);
            max = Math.max(max, current);
        }

        return max;
    }
}