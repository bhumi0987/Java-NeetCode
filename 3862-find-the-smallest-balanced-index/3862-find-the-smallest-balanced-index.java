class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long[] pre=new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        long suff=1;
        int ans=-1;
        for(int i=n-1;i>=0;i--){
            long sum=pre[i];
            if(sum==suff){
                ans=i;
            }
            if(suff>sum){
                break;
            }
            suff*=nums[i];
        }
        return ans;
    }
}