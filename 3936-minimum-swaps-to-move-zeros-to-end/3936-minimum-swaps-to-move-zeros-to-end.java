class Solution {
    public int minimumSwaps(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
        }
        int count1=0;
        int ans=nums.length-count;
        for(int i=ans;i<nums.length;i++){
            if(nums[i]==0){
                count1++;
            }
        }
        return count-count1;
    }
}