class Solution {
    public int trap(int[] height) {
       int left = 0;
        int right = height.length - 1;
        int leftm = height[0];
        int rightm = height[right];
        int res = 0;
        for(int i=0;i<height.length;i++){
            if(height[left]<height[right]){
                leftm = Math.max(leftm,height[left]);
                int diff = leftm - height[left];
                if(diff > 0){
                    res += diff;
                }
                left++;
            }
            else{
                rightm = Math.max(rightm,height[right]);
                int diff = rightm - height[right];
                if(diff>0){
                    res += diff;
                }
                right--;
            }
        }
        return res;
    }
}