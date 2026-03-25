class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long total=0;
        long[] row=new long[n];
        long[] col=new long[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                total+=grid[i][j];
                row[i]+=grid[i][j];
                col[j]+=grid[i][j];
            }
        }
        if(total%2!=0){
            return false;
        }
        long target=total/2;
        long sum=0;
        for(int i=0;i<n-1;i++){
            sum+=row[i];
            if(sum==target){
                return true;
            }
        }
        sum=0;
        for(int i=0;i<m-1;i++){
            sum+=col[i];
            if(sum==target){
                return true;
            }
        }
        return false;
    }
}