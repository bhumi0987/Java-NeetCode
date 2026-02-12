class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n=nums.length;
        int max=101;
        int[][] pre=new int[n+1][101];
        for(int i=0;i<n;i++){
            for(int j=0;j<max;j++){
                pre[i+1][j]=pre[i][j];
            }
            pre[i+1][nums[i]]++;
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0]+1;
            int r=queries[i][1]+1;
            List<Integer> diff=new ArrayList<>();
            for(int k=1;k<max;k++){
                if(pre[r][k]-pre[l-1][k]>0){
                    diff.add(k);
                }
            }
            if(diff.size()==1){
                ans[i]=-1;
            }
            else{
                int min=Integer.MAX_VALUE;
                for(int j=1;j<diff.size();j++){
                    min=Math.min(min,diff.get(j)-diff.get(j-1));
                }
                ans[i]=min;
            }
        }
        return ans;
    }
}