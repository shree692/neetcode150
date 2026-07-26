class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] req : prerequisites){
            int c = req[0];
            int p = req[1];
            adj.get(p).add(c);
            inDegree[c]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int pc = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            pc++;
            for(int n:adj.get(cur)){
                inDegree[n]--;
                if(inDegree[n] == 0){
                    queue.offer(n);
                }
            }
        }
        return pc == numCourses;
    }
}
