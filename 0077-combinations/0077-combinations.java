class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current) {

        // We have selected k numbers
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible number
        for (int i = start; i <= n; i++) {

            // Choose
            current.add(i);

            // Explore
            backtrack(i + 1, n, k, current);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}