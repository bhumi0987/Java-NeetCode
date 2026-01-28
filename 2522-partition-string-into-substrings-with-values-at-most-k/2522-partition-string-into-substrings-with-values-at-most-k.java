class Solution {
    public int solve(int idx,String s,int k,int[] dp){
        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=(int)1e9;
        long num=0;
        for(int i=idx;i<s.length();i++){
            num=num*10+(s.charAt(i)-'0');
            if(num>k){
                break;
            }
            ans=Math.min(ans,solve(i+1,s,k,dp)+1);
        }
        return dp[idx]=ans;
    }
    public int minimumPartition(String s, int k) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=solve(0,s,k,dp);
        return ans>=(int)1e9?-1:ans;
    }
}