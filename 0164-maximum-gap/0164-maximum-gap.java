class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 2) {
            return 0;
        }
        int maxDifference=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int currentMaxDiference=Integer.MIN_VALUE;
            currentMaxDiference=nums[i+1]-nums[i];
            maxDifference=Math.max(currentMaxDiference,maxDifference);
            
        }
        return maxDifference;
        
    }
}