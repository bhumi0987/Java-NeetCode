class Solution {
    public void solve(int n,int i,List<List<Integer>> arr,List<Integer> ds){
        if(i>=n){
            arr.add(new ArrayList<>(ds));
            return;
        }
        solve(n,i+1,arr,ds);
        ds.add(i);
        solve(n,i+1,arr,ds);
        ds.remove(ds.size()-1);
    }
    public boolean solve1(List<Integer> node,int n,int maxDistance,int[][] roads){
        int inf=100000;
        int[][] graph=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i],inf);
            graph[i][i]=0;
        }
        for(int[] it:roads){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            boolean flag=node.contains(u);
            boolean flag1=node.contains(v);
            if(flag&&flag1){
                graph[u][v]=Math.min(graph[u][v],w);
                graph[v][u]=Math.min(graph[v][u],w);
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][k]+graph[k][j]<graph[i][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(node.contains(i)&&node.contains(j)){
                    max=Math.max(max,graph[i][j]);
                }
            }
        }
        return max<=maxDistance;
    }
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        List<List<Integer>> arr=new ArrayList<>();
        solve(n,0,arr,new ArrayList<>());
        int ans=0;
        for(List<Integer> it:arr){
            if(solve1(it,n,maxDistance,roads)){
                ans++;
            }
        }
        return ans;
    }
}