class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<chars.length();i++){
            map.put(chars.charAt(i),vals[i]);
        }
        int count=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            count=Math.max(count+map.getOrDefault(s.charAt(i),s.charAt(i)-'a'+1),0);
            ans=Math.max(ans,count);
        }
        return ans;
    }
}