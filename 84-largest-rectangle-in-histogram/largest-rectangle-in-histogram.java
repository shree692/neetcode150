class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            left[i] = st.isEmpty()?-1:st.peek();
            st.push(i); 
        }
        st.clear();

        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            right[i] = st.isEmpty()?n:st.peek();
            st.push(i); 
        }
        int maxht = 0;
        for(int i = 0;i<n;i++){
            
            int width = right[i] - left[i] -1;
            maxht = Math.max(maxht,heights[i]*width);
        }
        return maxht;
    }
}