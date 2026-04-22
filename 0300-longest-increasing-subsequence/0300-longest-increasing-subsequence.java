class Solution {
    public int solve(int i,int[] nums,int[][] dp,int prev){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int nottake=solve(i+1,nums,dp,prev);
        int take=0;
        if(prev==-1||(prev!=-1&&nums[i]>nums[prev])){
            take=1+solve(i+1,nums,dp,i);
        }
        return dp[i][prev+1]=Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,nums,dp,-1);
    }
}