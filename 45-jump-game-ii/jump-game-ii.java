class Solution {
    public int jump(int[] nums) {
        int jumps=0,farthestpoint = 0,currentendpoint = 0;
        for(int i=0;i<nums.length-1;i++){
            farthestpoint = Math.max(farthestpoint,i + nums[i]);
            if(i == currentendpoint){
                jumps++;
                currentendpoint = farthestpoint;
            }
        }
        return jumps;
    }
}