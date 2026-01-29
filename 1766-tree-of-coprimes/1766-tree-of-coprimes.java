class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n=nums.length;
        int[][] arr=new int[51][51];
        for(int i=1;i<51;i++){
            for(int j=i;j<51;j++){
                if(gcd(i,j)==1){
                    arr[i][j]=1;
                    arr[j][i]=1;
                }
            }
        }
        int[] parent=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        Map<Integer,int[][]> map=new HashMap<>();
        int[][] dp=new int[51][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        map.put(0,dp);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        parent[0]=-1;
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int[] ans=new int[n];
        ans[0]=-1;
        int d=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                for(int it:adj.get(curr)){
                    if(it!=parent[curr]){
                        parent[it]=curr;
                        q.offer(it);
                    }
                }
                if(curr==0){
                    continue;
                }
                else{
                    int prev=parent[curr];
                    dp=map.get(prev).clone();
                    dp[nums[prev]]=new int[]{prev,count-1};
                    int min=Integer.MAX_VALUE;
                    for(int v=1;v<=50;v++){
                        if(dp[v][0]!=-1&&arr[v][nums[curr]]==1){
                            if(count-dp[v][1]<min){
                                min=count-dp[v][1];
                                ans[curr]=dp[v][0];
                            }
                        }
                    }
                    map.put(curr,dp);
                    if(min==Integer.MAX_VALUE){
                        ans[curr]=-1;
                    }
                }
            }
            count++;
        }
        return ans;
    }
}