class Solution {
    public int solve(int[][] grid,int idx,int prev,int[][] dp){
        int m=grid[0].length;
        if(idx>=m){
            return 0;
        }
        if(prev!=-1&&dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=9;i++){
            if(i==prev){
                continue;
            }
            int cost=0;
            for(int j=0;j<grid.length;j++){
                if(grid[j][idx]!=i){
                    cost++;
                }
            }
            min=Math.min(min,cost+solve(grid,idx+1,i,dp));
        }
        if(prev!=-1){
            dp[idx][prev]=min;
        }
        return min;
    }
    public int minimumOperations(int[][] grid) {
        int m=grid[0].length;
        int[][] dp=new int[m][10];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(grid,0,-1,dp);
    }
}