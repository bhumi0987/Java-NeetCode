class Solution {
    int sum=0;
    int n;
    public int solve(int[] nums,int idx){
        if(idx<2){
            return 0;
        }
        int ans=0;
        if(nums[idx]-nums[idx-1]==nums[idx-1]-nums[idx-2]){
            ans=1+solve(nums,idx-1);
            sum+=ans;
        }
        else{
            solve(nums,idx-1);
        }
        return ans;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        n=nums.length;
        solve(nums,n-1);
        return sum;
    }
}