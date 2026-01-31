class Solution{
    public boolean isPossible(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map1=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int x:nums){
            if(map.get(x)==0){
                continue;
            }
            if(map1.getOrDefault(x-1,0)>0){
                map1.put(x-1,map1.get(x-1)-1);
                map1.put(x,map1.getOrDefault(x,0)+1);
                map.put(x,map.get(x)-1);
            }
            else if(map.getOrDefault(x+1,0)>0&&map.getOrDefault(x+2,0)>0){
                map.put(x,map.get(x)-1);
                map.put(x+1,map.get(x+1)-1);
                map.put(x+2,map.get(x+2)-1);
                map1.put(x+2,map1.getOrDefault(x+2,0)+1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
