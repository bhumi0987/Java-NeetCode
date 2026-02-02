class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n=nums.length;
        long min=Long.MAX_VALUE;
        long sum=0;
        TreeSet<Integer> using=new TreeSet<>((a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]);
        TreeSet<Integer> waiting=new TreeSet<>((a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]);
        for(int i=1;i<=dist+1;i++){
            using.add(i);
            sum+=nums[i];
        }
        while(using.size()>k-1){
            int idx=using.pollLast();
            sum-=nums[idx];
            waiting.add(idx);
        }
        min=Math.min(min,sum);
        for(int i=1;i+dist+1<n;i++){
            waiting.add(i+dist+1);
            if(using.contains(i)){
                using.remove(i);
                sum-=nums[i];
                int idx=waiting.pollFirst();
                using.add(idx);
                sum+=nums[idx];
            }else{
                waiting.remove(i);
                int wmin=waiting.first();
                int umax=using.last();
                if(nums[wmin]<nums[umax]){
                    using.remove(umax);
                    waiting.add(umax);
                    sum-=nums[umax];
                    waiting.remove(wmin);
                    using.add(wmin);
                    sum+=nums[wmin];
                }
            }
            min=Math.min(min,sum);
        }
        return min+nums[0];
    }
}