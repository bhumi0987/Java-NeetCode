class Solution {
    public long solve(long sum){
        while(sum>=10){
            sum/=10;
        }
        return sum;
    }
    public int countValidSubarrays(int[] nums,int x){
        int count=0;
        long sum;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum%10==x&&solve(sum)==x){
                    count++;
                }
            }
        }
        return count;
    }
}