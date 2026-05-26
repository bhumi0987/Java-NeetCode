class Solution {
    public int getWinner(int[] arr, int k) {
        int n=arr.length;
        int max=arr[0];
        if(n<=k){
            for(int i=1;i<arr.length;i++){
                max=Math.max(max,arr[i]);
            }
            return max;
        }
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=1;i<arr.length;i++){
            dq.add(arr[i]);
        }
        int x=arr[0];
        int count=0;
        while(count<k){
            int y=dq.pollFirst();
            if(y>x){
                dq.offerLast(x);
                x=y;
                count=1;
            }else{
                count++;
                dq.offerLast(y);
            }
        }
        return x;
    }
}