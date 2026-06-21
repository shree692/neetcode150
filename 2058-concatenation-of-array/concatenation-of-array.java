class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = 2 * nums.length;
        int m = nums.length;
        int[] res = new int[n];
        for(int i = 0;i<nums.length;i++){
            res[i] = nums[i];
        }
        for(int i = m;i<n;i++){
            res[i] = nums[i-m];
        }
        return res;
    }
}