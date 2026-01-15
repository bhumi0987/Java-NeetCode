class Solution {
    public int solve(int x,int y,int[] dp){
        if(x==y){
            return 0;
        }
        if(x<y){
            return y-x;
        }
        if(dp[x]!=-1){
            return dp[x];
        }
        int one=solve(x-1,y,dp)+1;
        int five=Integer.MAX_VALUE;
        int eleven=Integer.MAX_VALUE;
        if(x%11==0){
            eleven=solve(x/11,y,dp)+1;
        }else{
            int i=(11-(x+11)%11)+1;
            eleven=solve((x+i)/11,y,dp)+i;
        }
        if(x%5==0){
            five=solve(x/5,y,dp)+1;
        }else{
            int i=(5-(x+5)%5)+1;
            five=solve((x+i)/5,y,dp)+i;
        }
        return dp[x]=Math.min(one,Math.min(eleven,five));
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        int[] dp=new int[x+1];
        Arrays.fill(dp,-1);
        return solve(x,y,dp);
    }
}