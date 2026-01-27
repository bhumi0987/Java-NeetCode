class pair{
    int v;
    int w;
    public pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,2*w));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->(a.w-b.w));
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        pq.add(new pair(0,0));
        cost[0]=0;
        while(!pq.isEmpty()){
            pair temp=pq.poll();
            int curr=temp.w;
            int node=temp.v;
            int len=adj.get(node).size();
            if(node==n-1){
                return curr;
            }
            for(int i=0;i<len;i++){
                pair p=adj.get(node).get(i);
                if(cost[p.v]>curr+p.w){
                    pq.offer(new pair(p.v,curr+p.w));
                    cost[p.v]=curr+p.w;
                }
            }
        }
        return -1;
    }
}