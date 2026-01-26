class Solution {
    public int[] solve(int n,ArrayList<Integer>[] adj,int start){
        int[] dist=new int[n];
        Arrays.fill(dist,-1);
        dist[start]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int u=q.poll();
            for(int it:adj[u]){
                if(dist[it]==-1){
                    dist[it]=dist[u]+1;
                    q.add(it);
                }
            }
        }
        return dist;
    }
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] dx=solve(n,adj,x);
        int[] dy=solve(n,adj,y);
        int[] dz=solve(n,adj,z);
        int ans=0;
        for(int i=0;i<n;i++){
            long a=dx[i];
            long b=dy[i];
            long c=dz[i];
            if(a>b){
                long t=a;
                a=b;
                b=t;
            }
            if(b>c){
                long t=b;
                b=c;
                c=t;
            }
            if(a>b){
                long t=a;
                a=b;
                b=t; 
            }
            ans+=(a*a+b*b==c*c)?1:0;
        }
        return ans;
    }
}