class Solution {
    public int solve(int i,int j,int[][] grid,int[][] dp){
        if(i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        if(i>=grid.length||j>=grid[0].length){
            return Integer.MAX_VALUE/2;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=grid[i][j]+solve(i,j+1,grid,dp);
        int down=grid[i][j]+solve(i+1,j,grid,dp);
        return dp[i][j]=Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,grid,dp);
    }
}