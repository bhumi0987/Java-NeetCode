class Solution {
    int[] par;
    int[] size;
    int[] count;
    int[] bit;
    public int find(int u){
        if(u==par[u]){
            return u;
        }
        par[u]=find(par[u]);
        return par[u];
    }
    public void union(int u,int v){
        int p1=find(u);
        int p2=find(v);
        if(p1==p2){
            return;
        }
        count[size[p1]]--;
        count[size[p2]]--;
        par[p2]=p1;
        size[p1]+=size[p2];
        count[size[p1]]++;
    }
    public int findLatestStep(int[] arr, int m) {
        int n=arr.length;
        par=new int[n+1];
        size=new int[n+1];
        count=new int[n+1];
        bit=new int[n+2];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            int idx=arr[i];
            bit[idx]=1;
            count[1]++;
            if(bit[idx-1]>0){
                union(idx,idx-1);
            }
            if(bit[idx+1]>0){
                union(idx,idx+1);
            }
            if(count[m]>0){
                ans=i+1;
            }
        }
        return ans;
    }
}