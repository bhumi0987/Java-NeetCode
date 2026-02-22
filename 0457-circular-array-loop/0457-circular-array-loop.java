class Solution {
    public int solve(int[] arr,boolean flag,int curr){
        boolean dir=arr[curr]>=0;
        if(dir!=flag){
            return -1;
        }
        int next=(arr[curr]+curr)%arr.length;
        if(next<0){
            next+=arr.length;
        }
        if(next==curr){
            return -1;
        }
        return next;
    }
    public boolean circularArrayLoop(int[] nums) {
        int n=nums.length;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int slow=i;
                int fast=i;
                boolean flag=nums[i]>=0;
                while(true){
                    slow=solve(nums,flag,slow);
                    if(slow==-1){
                        break;
                    }
                    fast=solve(nums,flag,fast);
                    if(fast==-1){
                        break;
                    }
                    fast=solve(nums,flag,fast);
                    if(fast==-1){
                        break;
                    }
                    if(fast==slow){
                        return true;
                    }
                    vis[slow]=true;
                    vis[fast]=true;
                }
            }
        }
        return false;
    }
}