class Solution {
    public int solve(int idx,int[] nums,int target,int[] dp){
        if(idx==nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=Integer.MIN_VALUE;
        for(int i=idx+1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[idx])<=target){
                ans=Math.max(ans,1+solve(i,nums,target,dp));
            }
        }
        return dp[idx]=ans;
    }
    public int maximumJumps(int[] nums, int target) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=solve(0,nums,target,dp);
        if(ans>0){
            return ans;
        }
        return -1;
    }
}