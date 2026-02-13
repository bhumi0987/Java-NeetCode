class Solution {
    public int halveArray(int[] nums) {
        double sum=0;
        double k=0;
        int i=0;
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int it:nums){
            pq.offer((double)it);
            sum+=it;
        }
        while(sum-k>sum/2){
            double x=pq.poll();
            k+=x/2;
            pq.offer(x/2);
            i++;
        }
        return i;
    }
}