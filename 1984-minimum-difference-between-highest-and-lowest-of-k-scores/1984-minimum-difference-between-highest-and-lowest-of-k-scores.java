class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length){
            if(j-i+1==k){
                min=Math.min(min,Math.abs(nums[i]-nums[j]));
                i++;
            }
            j++;
        }
        return min;
    }
}