class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb){
                return false;
            }
            if(rank[pa]<rank[pb]){
                parent[pa]=pb;
            }
            else if(rank[pb]<rank[pa]){
                parent[pb]=pa;
            }
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
            return true;
        }
    }
    public boolean solve(int n,int[][] edges,int k,int target){
        DSU dsu=new DSU(n);
        int usededge=0;
        int upgrades=0;
        List<int[]> normal=new ArrayList<>();
        List<int[]> upgrade=new ArrayList<>();
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int s=it[2];
            int must=it[3];
            if(must==1){
                if(s<target){
                    return false;
                }
                if(!dsu.union(u,v)){
                    return false;
                }
                usededge++;
            }else{
                if(s>=target){
                    normal.add(it);
                }
                else if(2L*s>=target){
                    upgrade.add(it);
                }
            }
        }
        for(int[] e:normal){
            if(dsu.union(e[0],e[1])) {
                usededge++;
                if(usededge==n-1){
                    return true;
                }
            }
        }
        for(int[] e:upgrade){
            if(upgrades==k){
                break;
            }
            if(dsu.union(e[0],e[1])){
                upgrades++;
                usededge++;
                if(usededge==n-1){
                    return true;
                }
            }
        }

        return usededge==n-1;
    }
    public int maxStability(int n, int[][] edges, int k) {
        int low=0;
        int high=200000;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(n,edges,k,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}