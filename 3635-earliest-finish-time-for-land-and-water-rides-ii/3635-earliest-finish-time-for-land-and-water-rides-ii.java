class Solution {
    public int earliestFinishTime(int[] lt, int[] ld, int[] wt, int[] wd){
        int l=Integer.MAX_VALUE;
        int w=Integer.MAX_VALUE;
        int minl=Integer.MAX_VALUE;
        int minw=Integer.MAX_VALUE;
        int n=lt.length;
        int m=wt.length;
        for(int i=0;i<n;i++){
            l=Math.min(l,lt[i]+ld[i]);
        }
        for(int i=0;i<m;i++){
            w=Math.min(w,wt[i]+wd[i]);
            minw=Math.min(minw,Math.max(wt[i],l)+wd[i]);
        }
        for(int i=0;i<n;i++){
            minl=Math.min(minl,Math.max(lt[i],w)+ld[i]);
        }
        return Math.min(minw,minl);
    }
}