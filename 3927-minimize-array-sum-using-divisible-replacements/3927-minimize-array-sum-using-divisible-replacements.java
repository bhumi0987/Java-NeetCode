class Solution {
    public long minArraySum(int[] nums) {
        int max=0;
        for(int it:nums){
            if(it>max){
                max=it;
            }
        }
        boolean[] present=new boolean[max+1];
        for(int it:nums){
            present[it]=true;
        }
        int[] min=new int[max+1];
        for(int i=1;i<=max;i++){
            if(present[i]){
                for(int j=i;j<=max;j+=i){
                    if(min[j]==0){
                        min[j]=i;
                    }
                }
            }
        }
        long sum=0;
        for(int it:nums){
            sum+=min[it];
        }
        return sum;
    }
}