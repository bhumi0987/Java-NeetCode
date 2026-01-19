class Solution {
    int n;
    int m;
    public boolean solve(int[][] pre,int mid,int threshold){
        for(int i=mid;i<=n;i++){
            for(int j=mid;j<=m;j++){
                int sum=pre[i][j]-pre[i-mid][j]-pre[i][j-mid]+pre[i-mid][j-mid];
                if(sum<=threshold){
                    return true;
                }
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        n=mat.length;
        m=mat[0].length;
        int[][] pre=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                pre[i][j]=pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1]+mat[i-1][j-1];
            }
        }
        int low=0;
        int high=Math.min(n,m);
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(pre,mid,threshold)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}