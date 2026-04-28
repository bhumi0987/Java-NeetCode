class Solution {
    public int solve(int i,int amount,int[] coins,int[][] dp){
        if(i==coins.length-1){
            if(amount%coins[i]==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int notpick=solve(i+1,amount,coins,dp);
        int pick=0;
        if(coins[i]<=amount){
            pick=solve(i,amount-coins[i],coins,dp);
        }
        return dp[i][amount]=pick+notpick;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,amount,coins,dp);
    }
}