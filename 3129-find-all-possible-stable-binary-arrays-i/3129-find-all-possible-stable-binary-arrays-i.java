class Solution {
    public int mod=(int)1e9+7;
    public int solve(int i,int j,int flag,int limit,int[][][] dp){
        if(i<0||j<0){
            return 0;
        }
        if(i==0&&j==0){
            return 1;
        }
        if(i==0){
            if(j>0&&j<=limit&&flag==0){
                return 1;
            }
            return 0;
        }
        if(j==0){
            if(i>0&&i<=limit&&flag==1){
                return 1;
            }
            return 0;
        }
        if(dp[i][j][flag]!=-1){
            return dp[i][j][flag];
        }
        long ans=0;
        if(flag==1){
            for(int x=1;x<=Math.min(i,limit);x++){
                ans=(ans+solve(i-x,j,0,limit,dp))%mod;
            }
        }else{
            for(int x=1;x<=Math.min(j,limit);x++){
                ans=(ans+solve(i,j-x,1,limit,dp))%mod;
            }
        }
        return dp[i][j][flag]=(int)ans;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp=new int[zero+1][one+1][2];
        for(int[][] it:dp){
            for(int[] it1:it){
                Arrays.fill(it1,-1);
            }
        }
        int ans=solve(zero,one,1,limit,dp);
        int ans1=solve(zero,one,0,limit,dp);
        return (ans+ans1)%mod;
    }
}