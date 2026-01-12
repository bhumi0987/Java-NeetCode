class Solution {
    public int solve(int idx,int[] arr,int[] dp){
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=1;
        for(int i=0;i<idx;i++){
            if(arr[i]<arr[idx]&&Math.abs(idx-i)==1){
                ans=Math.max(ans,1+solve(i,arr,dp));
            }
        }
        return dp[idx]=ans;
    }
    public int solve1(int idx,int[] arr,int[] dp1){
        if(dp1[idx]!=-1){
            return dp1[idx];
        }
        int ans=1;
        for(int i=idx;i<arr.length;i++){
            if(arr[i]<arr[idx]&&Math.abs(idx-i)==1){
                ans=Math.max(ans,1+solve1(i,arr,dp1));
            }
        }
        return dp1[idx]=ans;
    }
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int ans=0;
        int[] dp=new int[n];
        int[] dp1=new int[n];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
        for(int i=1;i<n-1;i++){
            if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                ans=Math.max(ans,solve(i,arr,dp)+solve1(i,arr,dp1)-1);
            }
        }
        if(ans<3){
            return 0;
        }
        return ans;
    }
}