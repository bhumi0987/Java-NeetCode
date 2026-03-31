class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((nums[i]==1&&nums[j]==2)||(nums[i]==2&&nums[j]==1)){
                    min=Math.min(min,Math.abs(i-j));
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;  
    }
}