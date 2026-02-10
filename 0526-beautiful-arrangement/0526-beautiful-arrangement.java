class Solution {
    int ans=0;
    boolean[] vis;
    public void solve(int n,List<Integer> arr){
        if(arr.size()==n){
            ans++;
            return;
        }
        int pos=arr.size()+1;
        for(int i=1;i<=n;i++){
            if(vis[i]){
                continue;
            }
            if((i%pos)==0||(pos%i)==0){
                vis[i]=true;
                arr.add(i);
                solve(n,arr);
                arr.remove(arr.size()-1);
                vis[i]=false;
            }
        }
    }
    public int countArrangement(int n) {
        vis=new boolean[n+1];
        solve(n,new ArrayList<>());
        return ans;
    }
}