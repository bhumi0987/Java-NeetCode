class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] res={-1,-1};
        int max=0;
        for(int[] it:towers){
            int dist=Math.abs(it[0]-center[0])+Math.abs(it[1]-center[1]);
            if(dist<=radius){
                if(it[2]>max||(it[2]==max&&(res[0]==-1||it[0]<res[0]||(it[0]==res[0]&&it[1]<res[1])))){
                    max=it[2];
                    res[0]=it[0];
                    res[1]=it[1];
                }
            }
        }
        return res;
    }
}