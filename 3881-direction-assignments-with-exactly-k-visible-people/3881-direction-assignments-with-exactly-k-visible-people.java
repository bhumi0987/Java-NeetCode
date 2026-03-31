class Solution {
    public int countVisiblePeople(int n, int pos, int k) {
        long mod=1000000007;
        long l=fact(n-1);
        long d=(fact(n-1-k)*fact(k))%mod;
        long i=pow(d,mod-2,mod);
        long j=(l*i)%mod;
        return (int)((2*j)%mod);
    }
    public long fact(long n){
        long mod=1000000007;
        long fact=1;;
        for(long i=1;i<=n;i++){
            fact=(fact*i)%mod;
        }
        return fact;
    }
    public long pow(long x,long y,long mod){
        long r=1;
        while(y>0){
            if((y&1)==1) r=(r*x)%mod;
            x=(x*x)%mod;
            y>>=1;
        }
        return r;
    }
}