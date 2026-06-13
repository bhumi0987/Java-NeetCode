class pair{
    int node;
    int dist;
    public pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:times){
            int u=it[0]-1;
            int v=it[1]-1;
            int w=it[2];
            adj.get(u).add(new pair(v,w));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        pq.add(new pair(k-1,0));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int d=p.dist;
            int node=p.node;
            for(pair it:adj.get(node)){
                int newnode=it.node;
                int weight=it.dist;
                if(d+weight<dist[newnode]){
                    dist[newnode]=d+weight;
                    pq.add(new pair(newnode,dist[newnode]));
                }
            }
        }
        int time=0;
        for(int it:dist){
            if(it==Integer.MAX_VALUE){
                return -1;
            }
            time=Math.max(time,it);
        }
        return time;
    }
}