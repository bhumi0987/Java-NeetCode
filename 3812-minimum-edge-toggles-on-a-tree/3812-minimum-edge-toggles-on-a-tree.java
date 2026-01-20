class Solution {
    class pair{
        int node;
        int idx;
        public pair(int node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    List<List<pair>> adj=new ArrayList<>();
    List<Integer> s=new ArrayList<>();
    List<Integer> t=new ArrayList<>();
    List<Integer> ans=new ArrayList<>();
    public void solve(int u,int p,int edge){
        for(pair it:adj.get(u)){
            int v=it.node;
            int idx=it.idx;
            if(v==p){
                continue;
            }
            solve(v,u,idx);
        }
        if(s.get(u)!=t.get(u)&&edge!=-1){
            ans.add(edge);
            s.set(u,s.get(u)^1);
            s.set(p,s.get(p)^1);
        }
    }
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        for(char ch:start.toCharArray()){
            s.add(ch=='1'?1:0);
        }
        for(char ch:target.toCharArray()){
            t.add(ch=='1'?1:0);
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(new pair(v,i));
            adj.get(v).add(new pair(u,i));
        }
        solve(0,-1,-1);
        if(!s.get(0).equals(t.get(0))){
            return Arrays.asList(-1);
        }else{
            Collections.sort(ans);
            return ans;
        }
    }
}