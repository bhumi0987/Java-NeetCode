class Solution {
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public boolean solve(char[][] grid,int n,int m,int i,int j,int prevr,int prevc,boolean[][] vis){
        vis[i][j]=true;
        char ch=grid[i][j];
        for(int[] it:dir){
            int nrow=i+it[0];
            int ncol=j+it[1];
            if(nrow<0||nrow>=n||ncol<0||ncol>=m||grid[nrow][ncol]!=ch||(nrow==prevr&&ncol==prevc)){

                continue;
            }
            if(vis[nrow][ncol]||solve(grid,n,m,nrow,ncol,i,j,vis)){
                return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]&&solve(grid,n,m,i,j,-1,-1,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}