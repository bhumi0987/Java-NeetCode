class Solution {
    long inf=Long.MAX_VALUE/4;
    public long solve(int i,int k,long[][] dp,long[] pre){
        if(k==0){
            if(i==0){
                return 0;
            }
            return inf;
        }
        if(i==0){
            return inf;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        long ans=inf;
        for(int j=k-1;j<i;j++){
            long sum=pre[i]-pre[j];
            long prev=(dp[j][k-1]!=-1)?dp[j][k-1]:solve(j,k-1,dp,pre);
            long cost=sum*(sum+1)/2;
            ans=Math.min(ans,cost+prev);
        }
        return dp[i][k]=ans;
    }
    public long minPartitionScore(int[] nums, int k) {
        int n=nums.length;
        long[][] dp=new long[n+1][k+1];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        long[] pre=new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        return solve(n,k,dp,pre);
    }
}