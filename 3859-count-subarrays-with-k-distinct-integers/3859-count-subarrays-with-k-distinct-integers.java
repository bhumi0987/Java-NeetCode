class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        long count=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count1=0;
        int pre=0;
        int i=0;
        int j=0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.get(nums[j])==m){
                count1++;
            }
            while(map.size()>k){
                if(map.get(nums[i])==m){
                    count1--;
                }
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
                pre=0;
            }
            if(count1==k&&map.size()==k){
                count++;
                while(map.get(nums[i])>m){
                    map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                    i++;
                    pre++;
                }
                count+=pre;
            }
            j++;
        }
        return count;
    }
}