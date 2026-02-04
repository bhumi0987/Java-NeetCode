class Solution {
    public long maxSumTrionic(int[] nums) {
        int n=nums.length;
        long ans=Long.MIN_VALUE;
        long[] pre=new long[n];
        long[] suff=new long[n];
        for(int i=0;i<n;i++){
            pre[i]=nums[i];
            if(i>0&&nums[i]>nums[i-1]){
                pre[i]=Math.max(nums[i]+nums[i-1],pre[i-1]+nums[i]);
            }
        }
        for(int i=n-1;i>=0;i--){
            suff[i]=nums[i];
            if(i<n-1&&nums[i]<nums[i+1]){
                suff[i]=Math.max(nums[i]+nums[i+1],suff[i+1]+nums[i]);
            }
        }
        for(int i=1;i<n-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                int j=i;
                long sum=0;
                while(j<n-1&&nums[j]>nums[j+1]){
                    sum+=nums[j];
                    j++;
                }
                if(j<n-1&&nums[j]<nums[j+1]){
                    ans=Math.max(ans,pre[i]-nums[i]+sum+suff[j]);
                }
                i=j;
            }
        }
        return ans;
    }
}