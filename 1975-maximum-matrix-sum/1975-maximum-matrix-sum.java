class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        int count=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    count++;
                }
                min=Math.min(min,Math.abs(matrix[i][j]));
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(count%2==0){
            return sum;
        }else{
            return sum-2*Math.abs(min);
        }
    }
}