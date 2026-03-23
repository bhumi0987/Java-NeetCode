class Solution {
    int mod=(int)(Math.pow(10,9)+7);
    long ans=-1;
    public void solve(int[][] grid,int r,int c,long pro){
        if(r==grid.length||c==grid[0].length){
            return;
        }
        if(r==grid.length-1&&c==grid[0].length-1){
            ans=Math.max(ans,pro*grid[r][c]);
            return;
        }
        if(grid[r][c]==0){
            ans=Math.max(ans,0);
            return;
        }
        solve(grid,r+1,c,pro*grid[r][c]);
        solve(grid,r,c+1,pro*grid[r][c]);
    }
    public int maxProductPath(int[][] grid) {
        solve(grid,0,0,1);
        return (int)(ans%mod);
    }
}