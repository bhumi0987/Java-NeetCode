class Solution {
    public int solve(int i,int[] nums,HashMap<String,Integer> dp,int product){
        if(i>=nums.length){
            return product;
        }
        String key=i+""+product;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int take=solve(i+1,nums,dp,product*nums[i]);
        int nottake=solve(i+1,nums,dp,nums[i]);
        if(i==0){
            product=nums[0];
        }
        int ans=Math.max(product,Math.max(take,nottake));
        dp.put(key,ans);
        return ans;
    }
    public int maxProduct(int[] nums) {
        HashMap<String,Integer> dp=new HashMap<>();
        return solve(0,nums,dp,1);
    }
}