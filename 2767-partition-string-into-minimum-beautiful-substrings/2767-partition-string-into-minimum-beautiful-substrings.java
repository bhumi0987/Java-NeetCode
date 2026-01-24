class Solution {
    public boolean solve1(int low,int high,String s){
        if(s.charAt(low)=='0'){
            return false;
        }
        int num=0;
        int x=1;
        for(int i=high;i>=low;i--){
            if(s.charAt(i)=='1'){
                num+=x;
            }
            x*=2;
        }
        while(num>1){
            if(num%5==0){
                num/=5;
            }else{
                return false;
            }
        }
        return true;
    }
    public int solve(int idx,String s,int[] dp){
        if(idx==s.length()){
            return 0;
        }
        int ans=(int)1e9;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        for(int j=idx;j<s.length();j++){
            if(solve1(idx,j,s)){
                ans=Math.min(ans,1+solve(j+1,s,dp));
            }
        }
        return dp[idx]=ans;
    }
    public int minimumBeautifulSubstrings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=solve(0,s,dp);
        if(ans==(int)1e9){
            return -1;
        }
        return ans;
    }
}