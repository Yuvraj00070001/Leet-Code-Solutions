class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDelete = arr[0];      // max sum ending here, no deletion used
        int withDelete = 0;         // max sum ending here, one deletion used
        int result = arr[0];        // tracks overall answer

        for (int i = 1; i < n; i++) {
            // Update withDelete BEFORE noDelete changes (uses previous noDelete)
            withDelete = Math.max(withDelete + arr[i], noDelete);
            
            // Update noDelete for current index
            noDelete = Math.max(arr[i], noDelete + arr[i]);

            result = Math.max(result, Math.max(noDelete, withDelete));
        }

        return result;
    }
}