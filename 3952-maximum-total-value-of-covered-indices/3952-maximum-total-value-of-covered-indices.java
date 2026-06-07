class Solution {
    public long solve(int i,int[] nums,String s,int taken,long[][] dp){
        int n=s.length();
        if(i>=n){
            return 0;
        }
        if(dp[i][taken]!=-1){
            return dp[i][taken];
        }
        long ans=solve(i+1,nums,s,0,dp);
        if(s.charAt(i)=='1'&&taken==0){
            ans=Math.max(ans,nums[i]+solve(i+1,nums,s,0,dp));
        }
        if(i+1<n&&s.charAt(i+1)=='1'){
            ans=Math.max(ans,nums[i]+solve(i+1,nums,s,1,dp));
        }
        return dp[i][taken]=ans;
    }
    public long maxTotal(int[] nums, String s) {
        int n=s.length();
        long[][] dp=new long[n][2];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,nums,s,0,dp);
    }
}