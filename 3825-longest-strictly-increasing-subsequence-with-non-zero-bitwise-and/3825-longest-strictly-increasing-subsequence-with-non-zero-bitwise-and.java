class Solution {
    public int solve(ArrayList<Integer> list){
        ArrayList<Integer> temp=new ArrayList<>();
        for(int it:list){
            int idx=Collections.binarySearch(temp,it);
            if(idx<0){
                idx=-(idx+1);
            }
            if(idx<temp.size()){
                temp.set(idx,it);
            }else{
                temp.add(it);
            }
        }
        return temp.size();
    }
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<=30;i++){
            int mask=1<<i;
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((mask&(nums[j]))==0){
                    continue;
                }
                list.add(nums[j]);
            }
            int res=solve(list);
            ans=Math.max(ans,res);
        }
        return ans;
    }
}