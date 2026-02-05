class Solution {
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public boolean isGoodArray(int[] nums) {
        int x=0;
        for(int it:nums){
            x=gcd(x,it);
            if(x==1){
                return true;
            }
        }  
        return false;
    }
}