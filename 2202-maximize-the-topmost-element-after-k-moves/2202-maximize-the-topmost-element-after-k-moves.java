class Solution {
    public int maximumTop(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int it:nums){
            max=Math.max(max,it);
        }
        if(n==1&&k%2!=0){
            return -1;
        }
        if(k>n){
            return max;
        }
        int ans=0;
        for(int i=0;i<k-1;i++){
            ans=Math.max(ans,nums[i]);
        }
        if(k<nums.length){
            ans=Math.max(ans,nums[k]);
        }
        return ans;
    }
}