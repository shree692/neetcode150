class Solution {
    List<List<String>> ans = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> anti = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] c:board){
            Arrays.fill(c,'.');
        }
            backtrack(0,board);
            return ans;
        
    }
    void backtrack(int row,char[][] board){
        if(row==board.length){
            List<String> list = new ArrayList<>();
            for(char[] r:board){
                list.add(new String(r));}
                ans.add(list);
                return;
            
        }
        for(int col=0;col<board.length;col++){
            if(cols.contains(col) || diag.contains(row-col) || anti.contains(row+col)) continue;
            cols.add(col);
            diag.add(row-col);
            anti.add(row+col);
            board[row][col] = 'Q';
            backtrack(row+1,board);
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row-col);
            anti.remove(row+col);
        }
    }
}
