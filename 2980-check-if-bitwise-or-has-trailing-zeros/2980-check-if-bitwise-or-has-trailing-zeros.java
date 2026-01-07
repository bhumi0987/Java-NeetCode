class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int count=0;
        for(int it:nums){
            if(it%2==0){
                count++;
            }
        }
        return count>=2;
    }
}