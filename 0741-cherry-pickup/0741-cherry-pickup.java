class Solution {
    public int solve(int r1,int c1,int r2,int c2,int[][] grid,int[][][][] dp,int n){
        if(r1>=n||r2>=n||c1>=n||c2>=n||grid[r1][c1]==-1||grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==n-1&&c1==n-1){
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2][c2]!=-1){
            return dp[r1][c1][r2][c2];
            
        }
        int ans=0;
        if(r1==r2&&c1==c2){
            ans+=grid[r1][c1];
        }else{
            ans+=grid[r1][c1];
            ans+=grid[r2][c2];
        }
        int f1=solve(r1,c1+1,r2,c2+1,grid,dp,n);
        int f2=solve(r1+1,c1,r2,c2+1,grid,dp,n);
        int f3=solve(r1+1,c1,r2+1,c2,grid,dp,n);
        int f4=solve(r1,c1+1,r2+1,c2,grid,dp,n);
        ans+=Math.max(Math.max(f1,f2),Math.max(f3,f4));
        return dp[r1][c1][r2][c2]=ans;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int[][][][] dp=new int[50][50][50][50];
        for(int[][][] it:dp){
            for(int[][] it1:it){
                for(int[] it2:it1){
                    Arrays.fill(it2,-1);
                }
            }
        }
        return Math.max(0,solve(0,0,0,0,grid,dp,n));
    }
}