class Solution {
    public long minEnergy(int n, int brightness, int[][] interval) {
        Arrays.sort(interval,(a,b)->a[0]-b[0]);
        long time=0;
        int start=interval[0][0];
        int end=interval[0][1];
        for(int i=1;i<interval.length;i++){
            if(interval[i][0]<=end+1){
                end=Math.max(end,interval[i][1]);
            }else{
                time+=end-start+1;
                start=interval[i][0];
                end=interval[i][1];
            }
        }
        time+=end-start+1;
        long total=(brightness+2)/3;
        return total*time;
    }
}