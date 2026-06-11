class Solution {
    int mod=(int)1e9+7;
    public int solve(List<List<Integer>> adj,int i,int par){
        int max=0;
        for(int it:adj.get(i)){
            if(it==par){
                continue;
            }
            max=Math.max(max,solve(adj,it,i));
        }
        return 1+max;
    }
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=edges.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans=solve(adj,1,0)-1;
        int res=1;
        for(int i=0;i<ans-1;i++){
            res=(res*2)%mod;
        }
        return res;
    }
}