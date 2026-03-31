class Solution {
    public int solve(int[][] grid,int i,int j,int xor,int[][][] dp){
        if(i<0||j<0){
            return Integer.MAX_VALUE; 
        }
        xor^=grid[i][j];
        if(i==0&&j==0){
            return xor;
        }
        if(dp[i][j][xor]!=-1){
            return dp[i][j][xor];
        }
        int left=solve(grid,i-1,j,xor,dp);
        int up=solve(grid,i,j-1,xor,dp);
        return dp[i][j][xor]=Math.min(left,up);
    }
    public int minCost(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n+1][m+1][1024];
        for(int[][] it:dp){
            for(int[] it1:it){
                Arrays.fill(it1,-1);
            }
        }
        return solve(grid,n-1,m-1,0,dp);
    }
}