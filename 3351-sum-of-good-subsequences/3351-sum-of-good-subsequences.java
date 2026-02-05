class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        int n=(int)1e5;
        int mod=(int)1e9+7;
        long[] dp1=new long[n+10];
        long[] dp2=new long[n+10];
        for(int i=0;i<nums.length;i++){
            dp1[nums[i]]+=nums[i];
            dp2[nums[i]]+=1;
            if(nums[i]-1>=0){
                dp1[nums[i]]=(dp1[nums[i]]+dp1[nums[i]-1])%mod;
                dp1[nums[i]]=(dp1[nums[i]]+(dp2[nums[i]-1]*nums[i])%mod)%mod;
                dp2[nums[i]]=(dp2[nums[i]]+dp2[nums[i]-1])%mod;
            }
            dp1[nums[i]]=(dp1[nums[i]]+dp1[nums[i]+1])%mod;
            dp1[nums[i]]=(dp1[nums[i]]+(dp2[nums[i]+1]*nums[i])%mod)%mod;
            dp2[nums[i]]=(dp2[nums[i]]+dp2[nums[i]+1])%mod;
        }
        long sum=0;
        for(int i=0;i<=n;i++){
            sum=(sum+dp1[i])%mod;
        }
        return (int)sum%mod;
    }
}