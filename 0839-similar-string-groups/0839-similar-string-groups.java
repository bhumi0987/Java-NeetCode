class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    } 
    private void union(int x,int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }
        else if(rank[x]>rank[y]){
            parent[y]=x;
        }
        else{
            parent[x]=y;
            rank[y]++;
        }
    }
    public boolean solve1(String s,String t){
        int ch=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                ch++;
            }
            if(ch>2){
                return false;
            }
        }
        return ch==0||ch==2;
    }
    public void solve(String[] strs){
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(solve1(strs[i],strs[j])){
                    int x=find(i);
                    int y=find(j);
                    if(x!=y){
                        union(x,y);
                    }
                }
            }
        }
    }
    public int numSimilarGroups(String[] strs) {
        parent=new int[strs.length];
        rank=new int[strs.length];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        solve(strs);
        int ans=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i){
                ans++;
            }
        }
        return ans;
    }
}