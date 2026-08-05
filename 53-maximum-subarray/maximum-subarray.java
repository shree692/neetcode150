class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int max = nums[0];
        for(int n:nums){
            curr += n;
            max = Math.max(curr,max);
            if(curr<0){
                curr = 0;
            }
        }
        return max;
    }
}
