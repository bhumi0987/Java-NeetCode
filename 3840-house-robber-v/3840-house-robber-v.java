class Solution {
    public long solve(int idx,int[] nums,int[] colors,long[] dp){
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long take;
        if(idx>0&&colors[idx]==colors[idx-1]){
            take=nums[idx]+solve(idx-2,nums,colors,dp);
        }else{
            take=nums[idx]+solve(idx-1,nums,colors,dp);
        }
        long skip=solve(idx-1,nums,colors,dp);
        return dp[idx]=Math.max(take,skip);
    }
    public long rob(int[] nums, int[] colors) {
        long[] dp=new long[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums.length-1,nums,colors,dp);
    }
}