class Solution {
    public boolean solve(int[] arr,int i,Boolean[] dp,int n){
        if(i<0||i>=n||arr[i]==-1){
            return false;
        }
        if(arr[i]==0){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int val=arr[i];
        arr[i]=-1;
        return dp[i]=solve(arr,i-val,dp,n)||solve(arr,i+val,dp,n);
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Boolean[] dp=new Boolean[n];
        return solve(arr,start,dp,n);
    }
}