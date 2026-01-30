class Solution {
    public int solve(int idx,int prev,int[][] clips,int time,int[][] dp){
        if(prev>=time){
            return 1;
        }
        if(idx==clips.length){
            if(prev<time){
                return (int)1e5;
            }
            return 1;
        }
        if(dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        int ans=(int)1e5;
        for(int j=idx;j<clips.length;j++){
            if(clips[j][0]<=prev){
                int x=Math.max(clips[j][1],prev);
                ans=Math.min(ans,1+solve(j+1,x,clips,time,dp));
            }
        }
        return dp[idx][prev]=ans;
    }
    public int videoStitching(int[][] clips, int time) {
        int[][] dp=new int[101][101];
        Arrays.sort(clips,(a,b)->a[0]-b[0]);
        int ans=(int)1e5;
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int i=0;i<clips.length;i++){
            if(clips[i][0]==0){
                ans=Math.min(ans,solve(i+1,clips[i][1],clips,time,dp));
            }
        }
        if(ans==(int)1e5){
            return -1;
        }
        return ans;
    }
}