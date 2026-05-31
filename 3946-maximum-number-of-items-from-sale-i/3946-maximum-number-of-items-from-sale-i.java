class Solution {
    int min=Integer.MAX_VALUE;
    int[] freq=new int[1501];
    public int solve(int i,int[][] items,int budget,int[][] dp){
        if(budget<0){
            return 0;
        }
        if(i>=items.length){
            return budget/min;
        }
        if(dp[i][budget]!=-1){
            return dp[i][budget];
        }
        int pick=0;
        int notpick=0;
        if(budget>=items[i][1]){
            pick=freq[i]+solve(i+1,items,budget-items[i][1],dp);
        }
        notpick=solve(i+1,items,budget,dp);
        return dp[i][budget]=Math.max(pick,notpick);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,items[i][1]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(items[j][0]%items[i][0]==0){
                    freq[i]++;
                }
            }
        }
        int[][] dp=new int[1501][1501];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,items,budget,dp);
    }
}