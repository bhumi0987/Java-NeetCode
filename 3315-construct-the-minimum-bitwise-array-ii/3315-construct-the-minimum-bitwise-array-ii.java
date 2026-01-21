class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] ans=new int[nums.size()];
        for(int i=0;i<n;i++){
            int x=nums.get(i);
            if(x%2==0){
                ans[i]=-1;
                continue;
            }
            int d=0;
            while((x&(1<<d))!=0){
                d++;
            }
            x-=(1<<(d-1));
            ans[i]=x;
        }
        return ans;
    }
}