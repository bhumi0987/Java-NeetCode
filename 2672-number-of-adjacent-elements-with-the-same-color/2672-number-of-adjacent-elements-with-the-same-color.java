class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] arr=new int[n];
        int len=queries.length;
        int[] ans=new int[len];
        int count=0;
        for(int i=0;i<len;i++){
            int idx=queries[i][0];
            int color=queries[i][1];
            int prev=idx>0?arr[idx-1]:0;
            int next=idx>=n-1?0:arr[idx+1];
            if(arr[idx]!=0&&arr[idx]==prev){
                count--;
            }
            if(arr[idx]!=0&&arr[idx]==next){
                count--;
            }
            arr[idx]=color;
            if(arr[idx]==prev){
                count++;
            }
            if(arr[idx]==next){
                count++;
            }
            ans[i]=count;
        }
        return ans;
    }
}