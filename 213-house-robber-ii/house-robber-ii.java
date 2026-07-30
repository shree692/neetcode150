class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return (Math.max(robber(nums,0,nums.length-2),robber(nums,1,nums.length-1)));
    }
    public int robber(int[] nums,int start,int end){
        int prev1 = 0;
        int prev2 = 0;
        for(int i=start;i<=end;i++){
            int current = Math.max(prev2 + nums[i],prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
