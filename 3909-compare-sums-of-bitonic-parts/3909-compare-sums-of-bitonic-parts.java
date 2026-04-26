class Solution {
    public int compareBitonicSums(int[] nums) {
        int n=nums.length;
        long[] pre=new long[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int peak=-1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                peak=i;
                break;
            }
        }
        long sum=pre[peak];
        long sum1=0;
        if(peak==0){
            sum1=pre[n-1];
        }
        else{
            sum1=pre[n-1]-pre[peak-1];
        }
        if(sum>sum1){
            return 0;
        }else if(sum<sum1){
            return 1;
        }else{
            return -1;
        }
    }
}