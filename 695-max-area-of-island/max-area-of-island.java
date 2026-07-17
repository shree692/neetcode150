
class Solution {
    int row,col,maxi=0;
    public int maxAreaOfIsland(int[][] grid) {
         row = grid.length;
         col = grid[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    maxi = Math.max(maxi,dfs(grid,i,j));
                }
            }
        }
        return maxi;
    }
    private int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0){return 0;}
        grid[i][j] = 0;
        return 1 + dfs(grid,i+1,j) + dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }
}
