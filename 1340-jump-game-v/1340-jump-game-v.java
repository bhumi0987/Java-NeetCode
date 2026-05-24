class Solution {
    public int solve(int i,int[] arr,int d,int n,int[] dp){
        int ans=1;
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i+1;j<=Math.min(i+d,n-1)&&arr[i]>arr[j];j++){
            ans=Math.max(ans,1+solve(j,arr,d,n,dp));
        }
        for(int j=i-1;j>=Math.max(i-d,0)&&arr[i]>arr[j];j--){
            ans=Math.max(ans,1+solve(j,arr,d,n,dp));
        }
        return dp[i]=ans;
    }
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int ans=1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            ans=Math.max(ans,solve(i,arr,d,n,dp));
        }
        return ans;
    }
}