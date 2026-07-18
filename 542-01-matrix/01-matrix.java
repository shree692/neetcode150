class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[row][col];
        int dist[][] = new int[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d:dir){
                int nr = curr[0]+d[0];
                int nc = curr[1]+d[1];

                if(nr>=0 && nc>=0 && nr<row && nc<col && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[curr[0]][curr[1]]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        } 
        return dist;
    }
}