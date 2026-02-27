class Solution {
    public int mod=1337;
    public int solve(int a,int b){
        int ans=1;
        a%=mod;
        for(int i=0;i<b;i++){
            ans=(ans*a)%mod;
        }
        return ans;
    }
    public int superPow(int a, int[] b) {
        int ans=1;
        for(int i=b.length-1;i>=0;i--){
            ans=(ans*solve(a,b[i]))%mod;
            a=solve(a,10);
        }
        return ans;
    }
}