class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            boolean found = false;

            // Search from i+1 to the end
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    found = true;
                    break;
                }
            }

            // If not found, search from beginning
            if (!found) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        found = true;
                        break;
                    }
                }
            }

            // No greater element anywhere
            if (!found) {
                ans[i] = -1;
            }
        }

        return ans;
    }
}