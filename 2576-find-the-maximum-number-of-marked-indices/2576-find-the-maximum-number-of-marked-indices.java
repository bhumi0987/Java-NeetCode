class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int i=0;
        int j=nums.length/2;
        while(i<nums.length/2&&j<nums.length){
            if(2*nums[i]<=nums[j]){
                ans++;
                i++;
                j++;
                continue;
            }
            j++;
        }
        return 2*ans;
    }
}