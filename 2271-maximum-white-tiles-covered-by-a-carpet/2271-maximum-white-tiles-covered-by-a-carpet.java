class Solution {
    public int solve(int[][] tiles,int t){
        int l=0;
        int r=tiles.length-1;
        int min=tiles.length;
        while(l<=r){
            int m=l+(r-l)/2;
            if(tiles[m][0]<=t&&tiles[m][1]>=t){
                return m;
            }else if(tiles[m][0]>t){
                min=Math.min(min,m);
                r=m-1;
            }else{  
                l=m+1;
            }
        }
        return min;
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->a[0]-b[0]);
        long[] pre=new long[tiles.length];
        long sum=0;
        int idx=0;
        for(int[] it:tiles){
            sum+=it[1]-it[0]+1;
            pre[idx]=sum;
            idx++;
        }
        long max=0;
        for(int i=0;i<tiles.length;i++){
            int last=tiles[i][0]+carpetLen;
            idx=solve(tiles,last);
            long val=i>0?pre[i-1]:0;
            long count=(idx>0?pre[idx-1]:0)-val; 
            if(idx<tiles.length){
                count+=Math.max(0,last-tiles[idx][0]);
            }
            max=Math.max(max,count);
        }
        return (int)max;
    }
}