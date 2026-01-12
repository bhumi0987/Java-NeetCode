class Solution {
    public boolean solve(int[] nums,int k,int target){
        int n=nums.length;
        int flips=0;
        int[] arr=nums.clone();
        for(int i=0;i<n-1;i++){
            if(arr[i]!=target){
                arr[i]*=-1;
                arr[i+1]*=-1;
                flips++;
            }
        }
        if(arr[n-1]!=target){
            return false;
        }
        return flips<=k;
    }
    public boolean canMakeEqual(int[] nums, int k) {
        return solve(nums,k,1)||solve(nums,k,-1);
    }
}
