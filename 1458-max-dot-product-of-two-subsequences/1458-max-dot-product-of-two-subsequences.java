class Solution {
    public int solve(int i,int j,int[] nums1,int[] nums2,int[][] dp){
        if(i>=nums1.length||j>=nums2.length){
            return (int)-1e9;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=(int)-1e9;
        ans=Math.max(ans,nums1[i]*nums2[j]+Math.max(0,solve(i+1,j+1,nums1,nums2,dp)));
        ans=Math.max(ans,solve(i+1,j,nums1,nums2,dp));
        ans=Math.max(ans,solve(i,j+1,nums1,nums2,dp));
        return dp[i][j]=ans;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,nums1,nums2,dp);
    }
}