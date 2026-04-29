class Solution {
    public int solve(int k,int n,int[][] dp){
        if(n==0||n==1){
            return n;
        }
        if(k==1){
            return n;
        }
        if(dp[k][n]!=-1){
            return dp[k][n];
        }
        int ans=1000000;
        int low=1;
        int high=n;
        int count=0;
        while(low<=high){
            int mid=low+(high-low)/2;;
            int left=solve(k-1,mid-1,dp);
            int right=solve(k,n-mid,dp);
            count=1+Math.max(left,right);
            if(left<right){
                low=mid+1;
            }else{
                high=mid-1;
            }
            ans=Math.min(ans,count);
        }
        return dp[k][n]=ans;
    }
    public int superEggDrop(int k, int n) {
        int[][] dp=new int[k+11][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(k,n,dp);
    }
}