class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean vis[] = new boolean[nums.length];
        backtrack(nums,vis,new ArrayList<>());
        return ans;
    }
    void backtrack(int[] nums,boolean[] vis,List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i]) continue;
            curr.add(nums[i]);
            vis[i] = true;
            backtrack(nums,vis,curr);
            curr.remove(curr.size()-1);
            vis[i] = false;

        }
    }
}
