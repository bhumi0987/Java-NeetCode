class Solution {
    public int fact(int n){
        if(n==1||n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public boolean isDigitorialPermutation(int n) {
        int[] pre=new int[10];
        pre[0]=1;
        for(int i=1;i<=9;i++){
            pre[i]=fact(i);
        }
        int ans=n;
        int sum=0;
        ArrayList<Integer> arr=new ArrayList<>();
        while(n>0){
            int x=n%10;
            int y=pre[x];
            arr.add(x);
            sum+=y;
            n/=10;
        }
        ArrayList<Integer> arr1=new ArrayList<>();
        while(sum>0){
            arr1.add(sum%10);
            sum/=10;
        }
        Collections.sort(arr);
        Collections.sort(arr1);

        return arr.equals(arr1);
    }
}