class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),0);
        return ans;
    }
    void backtrack(int[] nums,List<Integer> curr,int start){
        
        ans.add(new ArrayList<>(curr));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
           
            curr.add(nums[i]);

            backtrack(nums,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}