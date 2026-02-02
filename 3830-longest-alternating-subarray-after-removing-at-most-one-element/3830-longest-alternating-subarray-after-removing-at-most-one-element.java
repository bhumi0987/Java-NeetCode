class Solution {
    public int solve(int i,int[] nums,int n,int state,int[][] dp){
        if(i==n-1){
            return 1;
        }
        if(dp[i][state]!=-1){
            return dp[i][state];
        }
        if(nums[i]==nums[i+1]){
            return dp[i][state]=1;
        }
        int ans=1;
        if(state==0&&nums[i]>nums[i+1]){
            ans=1+solve(i+1,nums,n,1,dp);
        }
        else if(state==1&&nums[i]<nums[i+1]){
            ans=1+solve(i+1,nums,n,0,dp);
        }
        return dp[i][state]=ans;
    }
    public int solve1(int i,int[] nums,int n,int state,int[][] dp){
        if(i==0){
            return 1;
        }
        if(dp[i][state]!=-1){
            return dp[i][state];
        }
        if(nums[i]==nums[i-1]){
            return dp[i][state]=1;
        }
        int ans=1;
        if(state==0&&nums[i-1]>nums[i]){
            ans=1+solve1(i-1,nums,n,1,dp);
        }
        else if(state==1&&nums[i-1]<nums[i]){
            ans=1+solve1(i-1,nums,n,0,dp);
        }
        return dp[i][state]=ans;
    }
    public int longestAlternating(int[] nums) {
        int n=nums.length;
        if(n<2){
            return n;
        }
        int[][] dp=new int[n][2];
        int[][] dp1=new int[n][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int[] it:dp1){
            Arrays.fill(it,-1);
        }
        int max=1;
        for(int i=0;i<n;i++){
            max=Math.max(max,solve(i,nums,n,0,dp));
            max=Math.max(max,solve(i,nums,n,1,dp));
            max=Math.max(max,solve1(i,nums,n,0,dp1));
            max=Math.max(max,solve1(i,nums,n,1,dp1));
        }
        for(int i=1;i<n-1;i++){
            if(nums[i-1]<nums[i+1]){
                max=Math.max(solve(i+1,nums,n,0,dp)+solve1(i-1,nums,n,0,dp1),max);
            }
            if(nums[i-1]>nums[i+1]){
                max=Math.max(solve(i+1,nums,n,1,dp)+solve1(i-1,nums,n,1,dp1),max);
            }
        }
        return max;
    }
}