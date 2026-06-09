class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==0||m==0||grid[0][0]==1||grid[n-1][m-1]==1){
            return -1;
        }
        int[][] dir={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int dis=curr[2];
            if(row==n-1&&col==n-1){
                return dis;
            }
            vis[row][col]=true;
            for(int[] it:dir){
                int nrow=row+it[0];
                int ncol=col+it[1];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&!vis[nrow][ncol]&&grid[nrow][ncol]==0){
                    q.offer(new int[]{nrow,ncol,dis+1});
                    vis[nrow][ncol]=true;
                }
            }
        }
        return -1;
    }
}