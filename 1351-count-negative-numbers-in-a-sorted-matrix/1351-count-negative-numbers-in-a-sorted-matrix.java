class Solution {
    public int Counter(int []arr){
        int i=0,j=arr.length-1,count=0;
        while(i<j){
            if(arr[i]<0 ){
                count++;
            }
            if(arr[j]<0){
                count++;
            }
            i++;
            j--;
        }
        if(i==j){
            if(arr[i]<0){
                count++;
            }
        }
        return count;
    }
    public int countNegatives(int[][] grid) {
        int i=0,j=grid.length-1;
        int count=0;
        while(i<j){
            count+=Counter(grid[i])+Counter(grid[j]);
            i++;
            j--;
        }
        if(i==j){
            count+=Counter(grid[i]);
        }
        return count;
    }
}