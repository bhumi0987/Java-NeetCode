class Solution {
    int n;
    int m;
    long[][][] dp;
    long min=(long)-1e18;
    public long solve(int[] nums1,int[] nums2,int k,int i,int j){
        if(k==0){
            return 0;
        }
        if(n-i<k||m-j<k){
            return min;
        }
        if(i>=n||j>=m){
            return min;
        }
        if(dp[k][i][j]!=min){
            return dp[k][i][j];
        }
        long take=(long)nums1[i]*nums2[j]+solve(nums1,nums2,k-1,i+1,j+1);
        long skip1=(long)solve(nums1,nums2,k,i+1,j);
        long skip2=(long)solve(nums1,nums2,k,i,j+1);
        return dp[k][i][j]=Math.max(take,Math.max(skip1,skip2));
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        n=nums1.length;
        m=nums2.length;
        dp=new long[k+1][n+1][m+1];
        for(long[][] it:dp){
            for(long[] it1:it){
                Arrays.fill(it1,min);
            }
        }
        return solve(nums1,nums2,k,0,0);
    }
}