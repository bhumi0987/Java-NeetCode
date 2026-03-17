class Solution {
    public void solve1(int[] nums){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public int solve(int[] nums){
        int max=2;
        int diff=nums[1]-nums[0];
        int n=nums.length;
        int i=0;
        for(int j=2;j<n;j++){
            int curr=nums[j]-nums[j-1];
            if(curr==diff){
                max=Math.max(max,j-i+1);
                continue;
            }
            int l=j-1;
            int r=j;
            int cur=nums[l]+diff;
            while(r+1<n&&nums[r+1]-cur==diff){
                cur=nums[r+1];
                r++;
            }
            max=Math.max(max,r-i+1);
            diff=curr;
            i=l;
        }
        return max;
    }
    public int longestArithmetic(int[] nums) {
        int max=solve(nums);
        solve1(nums);
        return Math.max(max,solve(nums));
    }
}