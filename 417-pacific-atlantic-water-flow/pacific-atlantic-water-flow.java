class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] paci = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];
        for(int i=0;i<r;i++){
            dfs(heights,paci,i,0);
            dfs(heights,atl,i,c-1);
        }
        for(int j=0;j<c;j++){
            dfs(heights,paci,0,j);
            dfs(heights,atl,r-1,j);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(paci[i][j] && atl[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    void dfs(int[][] h,boolean[][] vis,int r,int c){
        if(vis[r][c]) return;
        vis[r][c] = true;
        for(int[] d:dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr<0 || nc<0 || nr==h.length || nc==h[0].length){
                continue;
            }
            if(h[nr][nc] >= h[r][c]){
                dfs(h,vis,nr,nc);
            }
        }
    }
}
