class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n=costs.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=costs[i];
            arr[i][1]=capacity[i];
        }
        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr[i][0]<budget){
                ans=Math.max(ans,arr[i][1]);
            }
        }
        int[] pre=new int[n];
        pre[0]=arr[0][1];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],arr[i][1]);
        }
        for(int i=1;i<n;i++){
            int rem=budget-arr[i][0];
            if(rem<=0){
                continue;
            }
            int low=0;
            int high=i-1;
            int idx=-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid][0]<rem){
                    idx=mid;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            if(idx!=-1){
                ans=Math.max(ans,pre[idx]+arr[i][1]);
            }
        }
        return ans;
    }
}