class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] ans=new int[n];
        int count=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                ans[i]=count;
            }else{
                count++;
                ans[i]=count;
            }
        }
        boolean[] ans1=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            ans1[i]=ans[u]==ans[v];
        }
        return ans1;
    }
}