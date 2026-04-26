class Solution {
    public boolean rev(int n,int x){
        int sum=0;
        while(n>0){
            int k=n%10;
            sum=sum*10+k;
            n/=10;
        }
        System.out.println(sum);
        if((sum%10)!=x){
            return true;
        }
        return false;
    }
    public boolean validDigit(int n, int x) {
        boolean flag=rev(n,x);
        System.out.println(flag);
        boolean flag1=false;
        while(n>0){
            int k=n%10;
            System.out.println(k);
            if(k==x){
                flag1=true;
                break;
            }
            n/=10;
        }
        System.out.println(flag1);
        if(flag&&flag1){
            return true;
        }
        return false;
    }
}