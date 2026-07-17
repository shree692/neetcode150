class Solution {
    int row;
    int col; 
    public int closedIsland(int[][] grid) {
       row = grid.length;
       col = grid[0].length;
       int count=0;
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j] == 0 && dfs(grid,i,j)){
                count++;
            }
        }
       }
       return count; 
    }
    boolean dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=row || j>=col){return false;}
        if(grid[i][j]==1) return true;
        grid[i][j] = 1;
        boolean bottom = dfs(grid,i+1,j);
        boolean top = dfs(grid,i-1,j);
        boolean right = dfs(grid,i,j+1);
        boolean left = dfs(grid,i,j-1);
        return bottom && top && right && left;
    }
}