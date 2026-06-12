class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length){
            return nums;

        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Queue<Integer> que = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int n:map.keySet()){
            que.add(n);
            if(que.size()>k){
                que.poll();
            }

        }
        int ans[] = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = que.poll();

        }
        return ans;
    }
}