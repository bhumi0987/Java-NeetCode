class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min=Integer.MAX_VALUE;
        long max=Integer.MIN_VALUE;
        for(int it:nums){
            min=Math.min(min,it);
            max=Math.max(max,it);
        }
        return (long)(max-min)*k;
    }
}