class Solution {
    public long countPairs(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            StringBuilder sb=new StringBuilder();
            int first=word.charAt(0)-'a';
            for(int i=0;i<word.length();i++){
                int diff=(word.charAt(i)-'a'-first+26)%26;
                sb.append(diff).append(',');
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        long ans=0;
        for (int i:map.values()){
            ans+=(long)i*(i-1)/2;
        }
        return ans;
    }
}