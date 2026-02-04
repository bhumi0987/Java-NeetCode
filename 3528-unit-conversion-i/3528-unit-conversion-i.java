class pair{
    int v;
    int w;
    public pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class Solution {
    public int mod=(int)1e9+7;
    public void dfs(int node,int[] ans,ArrayList<ArrayList<pair>> adj,int[] vis){
        vis[node]=1;
        for(pair it:adj.get(node)){
            if(vis[it.v]==0){
                ans[it.v]=(int)((1L*ans[node]*it.w)%mod);
                dfs(it.v,ans,adj,vis);
            }
        }
    }
    public int[] baseUnitConversions(int[][] conversions) {
        int n=conversions.length+1;
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<conversions.length;i++){
            int u=conversions[i][0];
            int v=conversions[i][1];
            int w=conversions[i][2];
            adj.get(u).add(new pair(v,w));
        }
        int[] ans=new int[n];
        int[] vis=new int[n];
        ans[0]=1;
        dfs(0,ans,adj,vis);
        return ans;
    }
}