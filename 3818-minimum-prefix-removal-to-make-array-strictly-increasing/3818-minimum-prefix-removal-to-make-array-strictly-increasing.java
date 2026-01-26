class Solution {
    public int minimumPrefixLength(int[] nums) {
        int ans=-1;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                ans=i-1;
            }
        }
        return ans+1;
    }
}