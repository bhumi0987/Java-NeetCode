class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]>((pre[n-1]-pre[i])/(n-i-1))){
                System.out.println((pre[n-1]-pre[i]));

                count++;
            }
        }
        return count;
    }
}