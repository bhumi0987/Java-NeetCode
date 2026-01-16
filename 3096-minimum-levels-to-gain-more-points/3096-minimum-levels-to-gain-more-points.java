class Solution {
    public int minimumLevels(int[] possible) {
        int n=possible.length;
        int[] pre=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            if(possible[i]==0){
                sum-=1;
            }else{
                sum+=1;
            }
            pre[i]=sum;
        }
        for(int i=0;i<n-1;i++){
            if(pre[i]>sum-pre[i]){
                return i+1;
            }
        }
        return -1;
    }
}