class Solution {
    int mod=(int)(1e9)+7;
    public long solve(int i,int j,int n,int x,int y,long[][] dp){
        if(i>=n){
            return 1;
        }
        if(j>x){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        long op1=(((solve(i+1,j+1,n,x,y,dp)*(y))%mod)*(x-j))%mod;
        long op2=(solve(i+1,j,n,x,y,dp)*j)%mod;
        return dp[i][j]=(op1+op2)%mod;
    }
    public int numberOfWays(int n, int x, int y) {
        long[][] dp=new long[n+1][x+1];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return (int)solve(0,0,n,x,y,dp);
    }
}