class Solution {
    public boolean solve(int[][] mat,int[][] target){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] solve1(int[][]mat){
        int n=mat.length;
        int[][] res=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[n-1-j][i]=mat[i][j];
            }
        }
        return res;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        if(solve(mat,target)){
            return true;
        }
        int count=3;
        while(count>0){
            mat=solve1(mat);
            if(solve(mat,target)){
                return true;
            }
            count--;
        }
        return false;
    }
}