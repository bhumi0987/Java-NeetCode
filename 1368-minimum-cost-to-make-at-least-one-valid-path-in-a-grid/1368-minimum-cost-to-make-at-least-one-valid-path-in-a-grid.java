class Solution {
    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};
    public int minCost(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int[] it:dist){
            Arrays.fill(it,1_000_000_000);
        }
        Deque<int[]> dq=new ArrayDeque<>();
        dist[0][0]=0;
        dq.offerFirst(new int[]{0,0});
        while(!dq.isEmpty()){
            int[] curr=dq.pollFirst();
            int x=curr[0];
            int y=curr[1];
            int z=dist[x][y];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m){
                    continue;
                }
                int cost=(grid[x][y]==i+1)?0:1;
                int ni=z+cost;
                if(ni<dist[nx][ny]){
                    dist[nx][ny]=ni;
                    if(cost==0){
                        dq.offerFirst(new int[]{nx,ny});
                    }else{
                        dq.offerLast(new int[]{nx,ny});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}