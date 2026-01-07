class Solution {
    public int check(int n){
        int max=0;
        int t=n;
        while(n!=0){
            int temp=n%10;
            max=Math.max(max,temp);
            n/=10;
        }
        if(t>=1000){
            return 1111*max;
        }
        else if(t>=100){
            return 111*max;
        }
        return 11*max;
    }
    public int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for(int i:nums){
            if(i<10){
                sum+=i;
            }
            else{
                sum+=check(i);
            }
        }
        return sum;
    }
}