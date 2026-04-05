class Solution {
    class pair{
        int count;
        long cost;
        public pair(int count,long cost){
            this.count=count;
            this.cost=cost;
        }
    }
    long[] pre;
    int n;
    pair[][] dp;
    private pair solve1(pair a,pair b){
        if(a.count!=b.count){
            return a.count>b.count?a:b;
        }
        return a.cost<=b.cost?a:b; 
    }
    public pair solve(int i,int prev){
        if(i>n-2){
            return new pair(0,0);
        }
        if(dp[i][prev]!=null){
            return dp[i][prev];
        }
        pair skip=solve(i+1,0);
        pair best=new pair(skip.count,skip.cost);
        if(prev==0){
            pair next=solve(i+1,1);
            pair take=new pair(next.count+1,next.cost+pre[i]);
            best=solve1(best,take);
        }
        return dp[i][prev]=best;
    }
    public long minIncrease(int[] nums) {
        n=nums.length;
        pre=new long[n];
        for(int i=1;i<n-1;i++){
            pre[i]=Math.max(0L,Math.max(nums[i-1],nums[i+1])+1L-nums[i]);
        }
        dp=new pair[n][2];
        return solve(1,0).cost;
    }
}