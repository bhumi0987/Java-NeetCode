class Solution {
    List<Integer> primes=new ArrayList<>();
    int[] spf;
    void sieve(int n){
        for(int i=2;i<=n;i++){
            if(spf[i]==0) {
                spf[i]=i;
                primes.add(i);
            }
            for(int p:primes){
                if((long)i*p>n||spf[i]<p){
                    break;
                }
                spf[i*p]=p;
            }
        }
    }
    public int minOperations(int[] A) {
        int n=A.length;
        int mx=0;
        for(int x:A){
            mx=Math.max(mx,x);
        }
        spf=new int[mx+101];
        sieve(mx+100);
        int res=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(!(A[i]>1&&spf[A[i]]==A[i])){
                    int nextPrime=nextPrime(A[i]);
                    res+=(nextPrime-A[i]);
                }
            }else{
                if(spf[A[i]]==A[i]){
                    res+=(A[i]==2?2:1);
                }
            }
        }
        return res;
    }
    private int nextPrime(int x) {
        int l=0;
        int r=primes.size()-1;
        int ans=primes.get(primes.size()-1);
        while(l<=r){
            int mid=(l+r)/2;
            if(primes.get(mid)>=x){
                ans=primes.get(mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}