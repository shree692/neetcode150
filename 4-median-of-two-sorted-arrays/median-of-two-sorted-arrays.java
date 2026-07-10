class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);

        int x=nums1.length;
        int y=nums2.length;
        int left =0;
        int right=x;
        
        while(left<=right){
            int partitionX = (left+right)/2;
            int partitionY = (x+y+1)/2 - partitionX;

            int maxleftX = (partitionX==0)? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxleftY = (partitionY==0)? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minrightX = (partitionX==x)? Integer.MAX_VALUE : nums1[partitionX];
            int minrightY = (partitionY==y)? Integer.MAX_VALUE : nums2[partitionY];

            if(maxleftX <= minrightY && maxleftY <= minrightX){
                if((x+y)%2 == 0){
                    return (Math.max(maxleftX,maxleftY)+Math.min(minrightX,minrightY))/2.0;
                }
                else{
                    return Math.max(maxleftX,maxleftY);
                }

            }
            else if(maxleftX > minrightY){
                right = partitionX - 1;

            }
            else{
                left = partitionX + 1;
            }
        }
        return 0;
    }
}