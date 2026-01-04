class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int it:nums){
            int sum=0;
            int count=0;
            for(int i=1;i*i<=it;i++){
                if(it%i==0){
                    int val=it/i;
                    if(i==val){
                        count+=1;
                        sum+=i;
                    }else{
                        count+=2;
                        sum+=i+val;
                    }
                    if(count>4){
                        break;
                    }
                }
            }
            if(count==4){
                ans+=sum;
            }
        }
        return ans;
    }
}