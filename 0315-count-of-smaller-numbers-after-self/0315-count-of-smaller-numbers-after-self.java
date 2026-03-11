class Solution {
    public int solve(List<Integer> list,int num){
        int low=0;
        int high=list.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(list.get(mid)<num){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int idx=solve(list,nums[i]);
            ans.add(idx);
            list.add(idx,nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}