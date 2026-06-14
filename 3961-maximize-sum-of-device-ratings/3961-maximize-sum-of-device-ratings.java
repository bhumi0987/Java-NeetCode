class Solution {
    public long maxRatings(int[][] units) {
        int n=units.length;
        int m=units[0].length;
        long sum=0;
        if(m==1){
            for(int i=0;i<n;i++){
                sum+=units[i][0];
            }
            return sum;
        }
        int minfirst=Integer.MAX_VALUE;
        long secondsum=0;
        for(int i=0;i<n;i++){
            Arrays.sort(units[i]);
            minfirst=Math.min(minfirst,units[i][0]);
            secondsum+=units[i][1];
        }
        for(int i=0;i<n;i++){
            long curr=secondsum-units[i][1]+minfirst;
            sum=Math.max(sum,curr);
        }
        return sum;
    }
}