class Solution {
    public int dfs(String s,int i,int j,int[][] dp){
        if(i>=j||i>=s.length()||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        if(s.charAt(i)!=s.charAt(j)){
            int x=dfs(s,i+1,j,dp);
            int y=dfs(s,i,j-1,dp);
            take=1+Math.min(x,y);
        }else{
            take=dfs(s,i+1,j-1,dp);
        }
        return dp[i][j]=take;
    }
    public int almostPalindromic(String s) {
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(dfs(s,i,j,dp)==0||dfs(s,i,j,dp)==1){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}