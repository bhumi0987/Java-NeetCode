class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long i=0;
        long j=0;
        long count=0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        while(j<n){
            map.put(nums[(int)j],map.getOrDefault(nums[(int)j],0)+1);
            while((long)(map.lastKey()-map.firstKey())*(j-i+1)>k){
                int val=nums[(int)i];
                map.put(val,map.get(val)-1);
                if(map.get(val)==0){
                    map.remove(val);
                }
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
}