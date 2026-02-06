class pair{
    String str="";
    int idx1=-1;
    int idx2=-1;
    pair(int idx1,int idx2,String str){
        this.idx1=idx1;
        this.idx2=idx2;
        this.str=str;
    }
    public String toString(int idx1,int idx2,String str){
        return idx1+"-"+"-"+idx2+"-"+str;
    }
}
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n=grid.length;
        int m=grid[0].length();
        HashSet<String> vis=new HashSet<>();
        Queue<pair> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[i].length();j++){
                if(grid[i].charAt(j)=='@'){
                    q.offer(new pair(i,j,""));
                }else if("abcdef".indexOf(grid[i].charAt(j))!=-1){
                    count++;
                }
            }
        }
        int step=0;
        int[] rdir={-1,1,0,0};
        int[] cdir={0,0,-1,1};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                pair curr=q.poll();
                int r=curr.idx1;
                int c=curr.idx2;
                String key=curr.str;
                if(!vis.contains(curr.toString(r,c,key))){
                    vis.add(curr.toString(r,c,key));
                }
                else{
                    continue;
                }
                if(count==key.length()){
                    return step;
                }
                for(int dir=0;dir<4;dir++){
                    int nr=rdir[dir]+r;
                    int nc=cdir[dir]+c;
                    if(nr<0||nc<0||nr>=n||nc>=m||grid[nr].charAt(nc)=='#'||vis.contains(new pair(nr,nc,key))){
                        continue;
                    }
                    char ch=grid[nr].charAt(nc);
                    if(key.indexOf(ch)==-1&&ch>='a'&&ch<='f'){
                        q.add(new pair(nr,nc,key+ch));
                    }
                    else if(ch>='A'&&ch<='F'&&key.indexOf(Character.toLowerCase(ch))==-1){
                        continue;
                    }else{
                        q.add(new pair(nr,nc,key));
                    }
                }
            }
            step++;
        }
        return -1;
    }
}