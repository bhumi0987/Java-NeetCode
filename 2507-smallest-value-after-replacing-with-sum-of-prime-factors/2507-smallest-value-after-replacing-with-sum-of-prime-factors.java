class Solution {
    public int solve(int n){
        if(n==1){
            return 0;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return i+solve(n/i);
            }
        }
        return n;
    }
    public int smallestValue(int n) {
        int x=solve(n);
        if(n==x){
            return n;
        }
        return smallestValue(x);
    }
}