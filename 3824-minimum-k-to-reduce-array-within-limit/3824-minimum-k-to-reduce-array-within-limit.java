class Solution {
    public int minimumK(int[] nums) {
        int[] arr=nums;
        int low=1;
        int high=100000;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long k=1L*mid*mid;
            long op=0;
            for(int it:arr){
                op+=(it+mid-1)/mid;
            }
            if(op<=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}