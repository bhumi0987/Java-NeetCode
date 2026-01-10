class Solution {
    static int[] prime;
    public void solve(){
        if(prime!=null){
            return;
        }
        prime=new int[1000001];
        for(int i=2;i<prime.length;i++){
            if(prime[i]==0){
                for(int j=i;j<prime.length;j+=i){
                    if(prime[j]==0){
                        prime[j]=i;
                    }
                }
            }
        }
    }
    boolean check(int x){
        if(x<=1){
            return false;
        }
        return prime[x]==x;
    }
    public int minJumps(int[] nums) {
        solve();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            while(x>1){
                map.computeIfAbsent(prime[x],k->new ArrayList<>()).add(i);
                x/=prime[x];
            }
        }
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] vis=new boolean[nums.length];
        q.add(0);
        vis[0]=true;
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int u=q.poll();
                if(u==nums.length-1){
                    return ans;
                }
                if(u-1>=0&&!vis[u-1]){
                    q.add(u-1);
                    vis[u-1]=true;
                }
                if(u+1<vis.length&&!vis[u+1]){
                    q.add(u+1);
                    vis[u+1]=true;
                }
                if(check(nums[u])&&map.containsKey(nums[u])){
                    List<Integer> neigh=map.get(nums[u]);
                    for(int v:neigh){
                        if(!vis[v]){
                            vis[v]=true;
                            q.add(v);
                        }
                        
                    }
                    map.get(nums[u]).clear();
                }
            }
            ans++;
        }
        return -1;
    }
}