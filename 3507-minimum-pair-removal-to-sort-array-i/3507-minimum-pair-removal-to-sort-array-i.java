class Solution {
    public int minimumPairRemoval(final int[] nums) {
        int n=nums.length;
        int count=0;
        while(n>1){
            int minSum=Integer.MAX_VALUE;
            int minIdx=-1;
            boolean isSorted=true;
            for(int i=1;i<n;i++){
                if(nums[i-1]+nums[i]<minSum){
                    minSum=nums[i-1]+nums[i];
                    minIdx=i - 1;
                }
                if(nums[i-1]>nums[i]){
                    isSorted=false;
                }
            }
            if(isSorted){
                return count;
            }
            nums[minIdx]=minSum;
            for(int i=minIdx+1;i<n-1;i++){
                nums[i]=nums[i+1];
            }
            count++; 
            n--;  
        }
        return count;
    }
}