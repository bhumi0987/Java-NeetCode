class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map1=new HashMap<>();
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        for(int it:map.values()){
            map1.put(it,map1.getOrDefault(it,0)+1);
        }
        for(int it:nums){
            if(map1.get(map.get(it))==1){
                return it;
            }
        }
        return -1;
    }
}