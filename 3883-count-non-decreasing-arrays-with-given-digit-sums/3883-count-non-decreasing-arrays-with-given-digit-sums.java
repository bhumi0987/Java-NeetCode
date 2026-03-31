class Solution {
    int mod=(int)(1e9+7);
    public boolean check(int s,int sum){
        int t=0;
        while(s>0){
            int lt=s%10;
            t+=lt;
            s=s/10;
        }
        return t==sum;
    }
    public int solve(int idx,int digit,int[] digitSum,int[][] dp){
        if(idx==digitSum.length){
            return 1;
        }
        if(digit>5000){
            return 0;
        }
        int ans=0;
        if(dp[idx][digit]!=-1){
            return dp[idx][digit];
        }
        if(check(digit,digitSum[idx])){
            ans=(ans+solve(idx+1,digit,digitSum,dp))%mod;
        }
        ans=(ans+solve(idx,digit+1,digitSum,dp))%mod;
        return dp[idx][digit]=ans;
    }
    public int countArrays(int[] digitSum) {
        int n=digitSum.length;
        int[][] dp=new int[n][5001];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,digitSum,dp);
    }
}