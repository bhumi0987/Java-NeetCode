class Solution {
    public int concatenatedBinary(int n) {
        int mod=1000000007;
        long ans=0;
        for(int i=1;i<=n;i++){
            String s=Integer.toBinaryString(i);
            ans=((ans<<s.length())|i)%mod;
        }
        return (int)ans;
    }
}