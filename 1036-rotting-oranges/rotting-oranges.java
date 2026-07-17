class Solution {
    public int orangesRotting(int[][] grid) {
      Queue<int[]> q = new LinkedList<>();
      int row = grid.length;
      int col = grid[0].length;
      int fresh = 0;
      for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]==2){
                q.offer(new int[]{i,j});
            }
            else if(grid[i][j]==1){
                fresh++;
                }
        }
      }
      if(fresh==0) return 0;
      int min = 0;
      int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
      while(!q.isEmpty()){
        int size = q.size();
        while(size --> 0){
            int[] curr = q.poll();
            for(int[] c : dir){
                int nr = curr[0]+c[0];
                int nc = curr[1]+c[1];
                if(nr>=0 && nc>=0 && nr<row && nc<col && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        min++;
      } 
      return fresh==0?min-1:-1; 
    }
}
