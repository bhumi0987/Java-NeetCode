class Solution {
    public int solve(int i,int j,int k,int[][] coins,int[][][] dp){
        int n=coins.length;
        int m=coins[0].length;
        if(i>=n||j>=m){
            return Integer.MIN_VALUE;
        }
        if(i==n-1&&j==m-1){
            return k>0?Math.max(0,coins[i][j]):coins[i][j];
        }
        if(dp[i][j][k]!=Integer.MIN_VALUE){
            return dp[i][j][k];
        }
        int ans=Math.max(solve(i+1,j,k,coins,dp),solve(i,j+1,k,coins,dp))+coins[i][j];
        if(k>0&&coins[i][j]<0){
            ans=Math.max(ans,Math.max(solve(i+1,j,k-1,coins,dp),solve(i,j+1,k-1,coins,dp)));
        }
        return dp[i][j][k]=ans;
    }
    public int maximumAmount(int[][] coins) {
        int n=coins.length;
        int m=coins[0].length;
        int[][][] dp=new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return solve(0,0,2,coins,dp);
    }
}