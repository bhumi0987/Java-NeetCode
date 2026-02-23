class Solution {
    public int scoreDifference(int[] nums) {
        int n=nums.length;
        boolean first=true;
        boolean second=false;
        int ans=0;
        int ans1=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                first=!first;
                second=!second;
            }
            if(i%6==5){
                first=!first;
                second=!second;
            }
            if(first){
                ans+=nums[i];
            }else{
                ans1+=nums[i];
            }
        }
        return ans-ans1;
    }
}