class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n=robots.length;
        int[][] pre=new int[n+2][2];
        for(int i=0;i<n;i++){
            pre[i][0]=robots[i];
            pre[i][1]=distance[i];
        }
        pre[n][0]=-1;
        pre[n][1]=0;
        pre[n+1][0]=Integer.MAX_VALUE;
        pre[n+1][1]=0;
        Arrays.sort(pre,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(walls);
        int ll=0;
        int lr=1;
        int rl=2;
        int rr=3;
        int[] dp=new int[4];
        int left=0;
        int right=1;
        for(int it:walls){
            while(it>pre[right][0]){
                left++;
                right++;
                int maxl=Math.max(dp[ll],dp[rl]);
                int maxr=Math.max(dp[lr],dp[rr]);
                dp[ll]=maxl;
                dp[lr]=maxl;
                dp[rl]=maxr;
                dp[rr]=maxr;
            }
            int r1=pre[left][0]+pre[left][1];
            int r2=pre[right][0]-pre[right][1];
            boolean flag=it<=r1;
            boolean flag1=it>=r2;
            boolean same=it==pre[right][0];
            if(flag1){
                dp[ll]++;
            }
            if(same){
                dp[lr]++;
            }
            if(flag||flag1){
                dp[rl]++;
            }
            if(flag||same){
                dp[rr]++;
            }
        }
        int ans=0;
        for(int it:dp){
            ans=Math.max(ans,it);
        }
        return ans;
    }
}