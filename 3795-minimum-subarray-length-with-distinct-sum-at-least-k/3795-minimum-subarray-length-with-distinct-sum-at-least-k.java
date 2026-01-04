class Solution {
    public int minLength(int[] nums, int k) {
        long sum=0;
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(i<nums.length){
            if(!map.containsKey(nums[i])){
                sum+=nums[i];
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(sum>=k){
                min=Math.min(min,i-j+1);
                map.put(nums[j],map.getOrDefault(nums[j],0)-1);
                if(map.get(nums[j])==0){
                    sum-=nums[j];
                    map.remove(nums[j]);
                }
                j++;
            }
            i++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}