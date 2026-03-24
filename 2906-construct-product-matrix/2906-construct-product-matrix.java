class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod=12345;
        int n=grid.length;
        int m=grid[0].length;
        int[][] ans=new int[n][m];
        long suff=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                ans[i][j]=(int)suff;
                suff=(suff*grid[i][j])%mod;
            }
        }
        long pre=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=(int)(((long)ans[i][j]*pre)%mod);
                pre=(pre*grid[i][j])%mod;
            }
        }
        return ans;
    }
}