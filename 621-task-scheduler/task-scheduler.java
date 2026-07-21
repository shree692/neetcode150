class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq){
           if(f>0){ pq.offer(f);}
        }
        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int cycle = n+1;
            while(cycle>0 && !pq.isEmpty()){
                int cur = pq.poll();
                if(cur>1){
                l.add(cur-1);
                }

                time++;
                cycle--;

            }
            for(int val:l){
                pq.offer(val);

            }
            if(pq.isEmpty()){
                break;
            }
            time += cycle;
        }
        return time;
    }
}
