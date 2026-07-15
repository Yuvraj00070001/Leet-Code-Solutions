class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentMax=nums[0];
        int maxSum=nums[0];

        int currentMin=nums[0];
        int minSum=nums[0];

        for(int i=1;i<nums.length;i++){

            currentMax=Math.max(nums[i],currentMax+nums[i]);
            maxSum=Math.max(currentMax,maxSum);

            currentMin=Math.min(nums[i],currentMin+nums[i]);
            minSum=Math.min(currentMin,minSum);

        }

        minSum=Math.abs(minSum);

        if(minSum>maxSum){
            return minSum;
            }
        return maxSum;
        
    }
}