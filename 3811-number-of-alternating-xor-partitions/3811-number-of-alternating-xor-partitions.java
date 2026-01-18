class Solution {
    public int mod=(int)1e9+7;
    public HashMap<String,Long> dp=new HashMap<>();
    public long solve(int idx,int flag,int prev,int target1,int target2,int[] pre){
        int n=pre.length;
        if(idx==n){
            return 1L;
        }
        if(idx==n-1){
            if(flag==0&&(pre[idx]^prev)==target1){
                return 1L;
            }
            if(flag==1&&(pre[idx]^prev)==target2){
                return 1L;
            }
            return 0L;
        }
        String key=""+idx+"_"+flag+"_"+prev;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        long ans=0L;
        ans=(ans+solve(idx+1,flag,prev,target1,target2,pre))%mod;
        if(flag==0&&(pre[idx]^prev)==target1){
            ans=(ans+solve(idx+1,1,prev^target1,target1,target2,pre))%mod;
        }
        if(flag==1&&(pre[idx]^prev)==target2){
            ans=(ans+solve(idx+1,0,prev^target2,target1,target2,pre))%mod;
        }
        dp.put(key,ans);
        return ans;
    }
    public int alternatingXOR(int[] nums, int target1, int target2) {
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=nums[i]^pre[i-1];
        }
        long ans=0;
        for(int i=0;i<n;i++){
            if(pre[i]==target1){
                ans=(ans+solve(i+1,1,target1,target1,target2,pre))%mod;
            }
        }
        return (int)ans;
    }
}