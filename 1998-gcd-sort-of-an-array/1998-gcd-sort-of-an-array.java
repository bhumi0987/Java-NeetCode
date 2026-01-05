class DSU {
    int[] parent;
    int[] size;
    public DSU(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int u){
        if(u!=parent[u]){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    public void union(int u,int v){
        int parU=find(u);
        int parV=find(v);
        if(parU==parV){
            return;
        }
        if(size[parU]<size[parV]){
            int temp=parU;
            parU=parV;
            parV=temp;
        }
        parent[parV]=parU;
        size[parU]+=size[parV];
    }
}
class Solution {
    public boolean gcdSort(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int it:nums){
            max=Math.max(max,it);
        }
        DSU dsu=new DSU(max);
        for(int it:nums){
            for(int i=2;i*i<=it;i++){
                if(it%i==0){
                    dsu.union(it,i);
                    dsu.union(it,it/i);
                }
            }
        }
        int[] arr=nums.clone();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(nums[i]!=arr[i]&&dsu.find(nums[i])!=dsu.find(arr[i])){
                return false;
            }
        }
        return true;
    }
}