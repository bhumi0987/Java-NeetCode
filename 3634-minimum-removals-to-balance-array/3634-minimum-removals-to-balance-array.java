class Solution {
    public int solve(int[] nums,long target,int n){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        Arrays.sort(nums);
        int ans=n;
        for(int i=0;i<n;i++){
            long target=(long)nums[i]*k;
            int idx=solve(nums,target,n);
            int x=i;
            int y=n-idx-1;
            ans=Math.min(ans,(x+y));
        }
        return ans;
    }
}