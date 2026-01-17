class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int it:map.values()){
            while(it>0&&set.contains(it)){
                it--;
                ans++;
            }
            set.add(it);
        }
        return ans;
    }
}