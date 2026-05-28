class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        List<HashSet<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }
        int[] indegree=new int[n];
        for(int[] it:edges){
            int u=it[0]-1;
            int v=it[1]-1;
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!adj.get(j).contains(i)){
                    continue;
                }
                for(int k=j+1;k<n;k++){
                    if(adj.get(k).contains(i)&&adj.get(k).contains(j)){
                        int count=(indegree[i]+indegree[j]+indegree[k])-6;
                        ans=Math.min(ans,count);
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}