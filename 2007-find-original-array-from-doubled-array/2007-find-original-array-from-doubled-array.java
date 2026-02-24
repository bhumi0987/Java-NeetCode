class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2!=0){
            return new int[0];
        }
        Arrays.sort(changed);
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:changed){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans=new int[n/2];
        int idx=0;
        for(int x:changed){
            if (map.get(x)==0){
                continue;
            }
            if(x==0){
                if(map.get(x)<2){
                    return new int[0];
                }
                map.put(x,map.get(x)-2);
                ans[idx++]=0;
            }else{
                if(!map.containsKey(2*x)||map.get(2*x)==0){
                    return new int[0];
                }
                map.put(x,map.get(x)-1);
                map.put(2*x,map.get(2*x)-1);
                ans[idx++]=x;
            }
        }
        return idx==n/2?ans:new int[0];
    }
}