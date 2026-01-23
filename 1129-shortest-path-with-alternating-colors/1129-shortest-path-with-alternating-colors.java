class pair{
    int node;
    char color;
    int dist;
    public pair(int node,char color,int dist){
        this.node=node;
        this.color=color;
        this.dist=dist;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans=new int[n];
        boolean[][] vis=new boolean[2][n];
        vis[0][0]=true;
        vis[1][0]=true;
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++){
            adj.get(redEdges[i][0]).add(new pair(redEdges[i][1],'R',1));
        }
        for(int i=0;i<blueEdges.length;i++){
            adj.get(blueEdges[i][0]).add(new pair(blueEdges[i][1],'B',1));
        }
        Arrays.fill(ans,Integer.MAX_VALUE);
        Queue<pair> q=new LinkedList<>();
        ans[0]=0;
        for(pair it:adj.get(0)){
            q.add(new pair(it.node,it.color,1));
            if(it.color=='R'){
                vis[0][it.node]=true;
            }else{
                vis[1][it.node]=true;
            }
        }
        while(!q.isEmpty()){
            pair curr=q.poll();
            int node=curr.node;
            char color=curr.color;
            int dist=curr.dist;
            ans[node]=Math.min(ans[node],dist);
            for(pair it:adj.get(node)){
                int currnode=it.node;
                char currcolor=it.color;
                int currdist=it.dist;
                if(color=='R'&&currcolor=='B'&&!vis[1][currnode]){
                    vis[1][currnode]=true;
                    q.add(new pair(currnode,currcolor,dist+currdist));
                }else if(color=='B'&&currcolor=='R'&&!vis[0][currnode]){
                    vis[0][currnode]=true;
                    q.add(new pair(currnode,currcolor,dist+currdist));
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE){
                ans[i]=-1;
            }
        }
        return ans;
    }
}