class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        int[] pre=new int[nums.length];
        pre[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(nums[i],max);
            pre[i]=gcd(max,nums[i]);
        }
        Arrays.sort(pre);
        long sum=0;
        int i=0;
        int j=pre.length-1;
        while(i<j){
            sum+=gcd(pre[i],pre[j]);
            i++;
            j--;
        }
        return sum;
    }
}