class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int n=destination[0]+1;
        int m=destination[1]+1;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int h=m-1;
        int v=n-1;
        while(h>0&&v>0){
            int total=dp[v][h-1];
            if(k<=total){
                sb.append('H');
                h--;
            }else{
                sb.append('V');
                k-=total;
                v--;
            }
        }
        while(h>0){
            sb.append('H');
            h--;
        }
        while(v>0){
            sb.append('V');
            v--;
        }
        return sb.toString();
    }
}