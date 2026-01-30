class Solution {
    long inf=Long.MAX_VALUE;
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Map<String,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        int size=0;
        int m=original.length;
        int n=source.length();
        long[][] dist=new long[201][201];
        for(long[] it:dist){
            Arrays.fill(it,inf);
        }
        for(int i=0;i<m;i++){
            if(!map.containsKey(original[i])){
                map.put(original[i],size++);
                set.add(original[i].length());
            }
            if(!map.containsKey(changed[i])){
                map.put(changed[i],size++);
            }
            int u=map.get(original[i]);
            int v=map.get(changed[i]);
            dist[u][v]=Math.min(dist[u][v],cost[i]);
        }
        for(int i=0;i<size;i++){
            dist[i][i]=0;
        }
        for(int k=0;k<size;k++){
            for(int i=0;i<size;i++){
                if(dist[i][k]!=inf){
                    for(int j=0;j<size;j++){
                        if(dist[k][j]!=inf){
                            dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                        }
                    }
                }
            }
        }
        long[] dp=new long[n+1];
        Arrays.fill(dp,inf);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(dp[i]==inf){
                continue;
            }
            if(source.charAt(i)==target.charAt(i)){
                dp[i+1]=Math.min(dp[i+1],dp[i]);
            }
            for(int it:set){
                if(i+it>n){
                    continue;
                }
                String s=source.substring(i,i+it);
                String t=target.substring(i,i+it);
                if(map.containsKey(s)&&map.containsKey(t)){
                    long d=dist[map.get(s)][map.get(t)];
                    if(d!=inf){
                        dp[i+it]=Math.min(dp[i+it],dp[i]+d);
                    }
                }
            }
        }
        return dp[n]==inf?-1:dp[n];
    }
}