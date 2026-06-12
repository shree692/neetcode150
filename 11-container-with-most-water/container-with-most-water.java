class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l<r){
            int width = r - l;
            int length = Math.min(heights[l],heights[r]);
            int ar = width * length;
            area = Math.max(area,ar);
            if(heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return area;
    }
}