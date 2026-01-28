class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n=values.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<values.length;i++){
            arr[i][0]=values[i];
            arr[i][1]=labels[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int count=0;
        int i=values.length-1;
        int[] freq=new int[20001];
        int sum=0;
        while(count<numWanted&&i>=0){
            if(freq[arr[i][1]]<useLimit){
                sum+=arr[i][0];
                freq[arr[i][1]]++;
                count++;
            }
            i--;
        }
        return sum;
    }
}