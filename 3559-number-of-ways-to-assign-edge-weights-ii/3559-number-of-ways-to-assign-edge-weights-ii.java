class Solution {
    public int mod=(int)(1e9+7);
    public int log=18;
    List<Integer>[] graph;
    int[][] parent;
    int[] depth;
    public long power(long a,long b){
        if(b==0){
            return 1;
        }
        long half=power(a,b/2);
        long res=(half*half)%mod;
        if((b&1)==1){
            res=(res*a)%mod;
        }
        return res;
    }
    public int solve(int u,int v){
        if(depth[u]<depth[v]){
            int temp=u;
            u=v;
            v=temp;
        }
        int diff=depth[u]-depth[v];
        for(int i=0;i<log;i++){
            if(((diff>>i)&1)==1){
                u=parent[i][u];
            }
        }
        if(u==v){
            return u;
        }
        for(int i=log-1;i>=0;i--){
            if(parent[i][u]!=parent[i][v]){
                u=parent[i][u];
                v=parent[i][v];
            }
        }
        return parent[0][u];
    }
    public void dfs(int node,int par){
        parent[0][node]=par;
        for(int it:graph[node]){
            if(it==par){
                continue;
            }
            depth[it]=depth[node]+1;
            dfs(it,node);
        }
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n=edges.length+1;
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        parent=new int[log][n+1];
        depth=new int[n+1];
        dfs(1,0);
        for(int i=1;i<log;i++){
            for(int j=1;j<=n;j++){
                parent[i][j]=parent[i-1][parent[i-1][j]];
            }
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            int lca=solve(u,v);
            int dist=depth[u]+depth[v]-2*depth[lca];
            ans[i]=(dist==0)?0:(int)power(2,dist-1);
        }
        return ans;
    }
}