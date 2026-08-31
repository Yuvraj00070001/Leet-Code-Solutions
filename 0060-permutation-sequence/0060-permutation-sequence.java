class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        // Store 1, 2, 3, ..., n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        StringBuilder ans = new StringBuilder();

        // Convert k to 0-based
        k--;

        for (int i = n; i >= 1; i--) {

            int blockSize = fact[i - 1];

            int index = k / blockSize;

            ans.append(numbers.get(index));

            numbers.remove(index);

            k = k % blockSize;
        }

        return ans.toString();
    }
}