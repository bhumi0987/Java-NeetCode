class Solution {
    public int solve(int[] nums,int idx,List<Map<Double,Integer>> dps,long k,double val){
        if(idx==nums.length){
            return Math.abs(val-k)<1e-9?1:0;
        }
        Map<Double,Integer> dp=dps.get(idx);
        if(dp.containsKey(val)){
            return dp.get(val);
        }
        int res=solve(nums,idx+1,dps,k,val*nums[idx]);
        res+=solve(nums,idx+1,dps,k,val/(double)nums[idx]);
        res+=solve(nums,idx+1,dps,k,val);
        dp.put(val,res);
        return res;
    }
    public int countSequences(int[] nums, long k) {
        int n=nums.length;
        List<Map<Double,Integer>> dps=new ArrayList<>();
        for(int i=0;i<n;i++){
            dps.add(new HashMap<>());
        }
        return solve(nums,0,dps,k,1.0);
    }
}