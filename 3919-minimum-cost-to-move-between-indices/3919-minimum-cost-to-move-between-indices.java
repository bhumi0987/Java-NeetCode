class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        long[] pre=new long[n];
        long[] suff=new long[n];
        for(int i=0;i<n-1;i++){
            long right=(long)nums[i+1]-nums[i];
            long left=(i>0)?(long)(nums[i]-nums[i-1]):Long.MAX_VALUE;
            pre[i+1]=pre[i]+(right<left?1:right);
        }
        for(int i=n-1;i>0;i--){
            long left=(long)nums[i]-nums[i-1];
            long right=(i<n-1)?(long)nums[i+1]-nums[i]:Long.MAX_VALUE;
            suff[i-1]=suff[i]+(left<=right?1:left);
        }
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l<=r){
                ans[i]=(int)(pre[r]-pre[l]);
            }else{
                ans[i]=(int)(suff[r]-suff[l]);
            }
        }
        return ans;
    }
}