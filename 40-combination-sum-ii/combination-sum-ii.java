class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(0,nums,target,new ArrayList<>());
        return ans;
    }
    void backtrack(int index,int[] nums,int target,List<Integer> curr){
        
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            curr.add(nums[i]);
            backtrack(i+1,nums,target-nums[i],curr);
            curr.remove(curr.size()-1);
        }
      
    }
}
