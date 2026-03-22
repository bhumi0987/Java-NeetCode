class Solution {
    public int solve(int idx,int xor,int[] nums,int target,int[][] dp){
        if(idx<0){
            if(xor==target){
                return 0;
            }
            return (int)1e9;
        }
        if(dp[idx][xor]!=-1){
            return dp[idx][xor];
        }
        int notpick=solve(idx-1,xor,nums,target,dp);
        int pick=1+solve(idx-1,xor^nums[idx],nums,target,dp);
        return dp[idx][xor]=Math.min(pick,notpick);
    }
    public int minRemovals(int[] nums, int target) {
        int xor=0;
        for(int it:nums){
            xor^=it;
        }
        int[][] dp=new int[nums.length][100000];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans=solve(nums.length-1,xor,nums,target,dp);
        if(ans>=(int)1e9){
            return -1;
        }
        return ans;
    }
}