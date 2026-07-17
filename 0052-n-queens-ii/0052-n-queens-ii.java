class Solution {
    public int totalNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        return solve(board,0);
    }
    public int solve(boolean[][] board,int row){
        if(row==board.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<board[0].length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count=count+solve(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }
    public boolean isSafe(boolean[][] board,int row,int col){
        int r=row-1;
        while(r>=0){
            if(board[r][col]==true){
                return false;
            }
            r--;
        }
        r=row-1;
        int c=col-1;
        while(r>=0 && c>=0){
            if(board[r][c]==true){
                return false;
            }
            r--;
            c--;
        }
        r=row-1;
        c=col+1;
        while(r>=0 && c<board[0].length){
            if(board[r][c]==true){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}