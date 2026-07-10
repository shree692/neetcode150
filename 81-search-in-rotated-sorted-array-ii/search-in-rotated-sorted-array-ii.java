class Solution {
    public boolean search(int[] nums, int target) {
         Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        return set.contains(target); 
    }
}