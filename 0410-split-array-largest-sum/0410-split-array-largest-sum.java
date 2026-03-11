class Solution {
    public boolean solve(int[] nums,int k,int mid){
        int count=1;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }else{
                count++;
                sum=nums[i];
            }
        }
        if(count<=k){
            return true;
        }
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int low=0;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(solve(nums,k,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}