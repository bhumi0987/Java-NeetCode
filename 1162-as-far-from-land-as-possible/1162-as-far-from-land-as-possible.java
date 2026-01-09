class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int n=grid.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    q.add(new int[]{i,j});
                }else{
                    grid[i][j]=Integer.MIN_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            int[] pos=q.poll();
            for(int[] it:dir){
                int nr=pos[0]+it[0];
                int nc=pos[1]+it[1];
                if(nr>=0&&nc>=0&&nr<n&&nc<n&&grid[nr][nc]<0){
                    q.add(new int[]{nr,nc});
                    grid[nr][nc]=grid[pos[0]][pos[1]]+1;
                    max=Math.max(max,grid[nr][nc]);
                }
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}