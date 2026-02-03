class Solution {
    public int minOperations(List<Integer> nums, int target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long sum=0;
        long count=0;
        for(int it:nums){
            pq.offer(it);
            sum+=it;
        }
        if(sum<target){
            return -1;
        }
        while(!pq.isEmpty()){
            int x=pq.poll();
            sum-=(long)x;
            if(x<=target){
                target-=x;
            }
            else if(x>target&&sum<target){
                count++;
                pq.offer(x/2);
                pq.offer(x/2);
                sum+=(long)x;
            }
        }
        return (int)count;
    }
}