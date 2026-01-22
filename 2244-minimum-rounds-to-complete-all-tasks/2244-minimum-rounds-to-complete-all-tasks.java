class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int it:tasks){
            map.put(it,map.getOrDefault(it,0)+1);
            set.add(it);
        }
        int count=0;
        for(int it:set){
            if(map.get(it)==1){
                return -1;
            }else{
                int x=map.get(it);
                count+=(x+2)/3;
            }
        }
        return count;
    }
}