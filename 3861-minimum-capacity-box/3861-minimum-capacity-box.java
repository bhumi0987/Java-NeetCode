class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n=capacity.length;
        int min=Integer.MAX_VALUE;
        int mini=-1;
        for(int i=0;i<n;i++){
            if(capacity[i]>=itemSize){
                if(min>capacity[i]){
                    min=Math.min(min,capacity[i]);
                    mini=i;
                }
            }
        }
        return mini;
    }
}