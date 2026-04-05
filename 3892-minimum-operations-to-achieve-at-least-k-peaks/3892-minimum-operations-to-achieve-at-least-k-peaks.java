class Solution {
    int n;
    int[][] dp;
    int inf=(int)1e8+7;
    public int solve(int idx,int k,int[] cost,int end){
        if(k==0){
            return 0;
        }
        if(idx>end){
            return inf;
        }
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        int pick=cost[idx]+solve(idx+2,k-1,cost,end);
        int notpick=solve(idx+1,k,cost,end);
        return dp[idx][k]=Math.min(pick,notpick);
    }
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        int max=n/2;
        if(max<k){
            return -1;
        }
        if(k==0){
            return 0;
        }
        int[] cost=new int[n];
        for(int i=0;i<n;i++){
            int prev=(i+n-1)%n;
            int next=(i+1)%n;
            cost[i]=Math.max(0,Math.max(nums[prev],nums[next])-nums[i]+1);
        }
        dp=new int[n+1][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans=solve(1,k,cost,n-1);
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans1=cost[0]+solve(2,k-1,cost,n-2);
        int res=Math.min(ans,ans1);
        return res==Integer.MAX_VALUE?-1:res;
    }
}