class Solution {
    public String mergeCharacters(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                sb.append(s.charAt(i));
            }else{
                if((i-map.get(s.charAt(i)))<=k){
                    for(Character ch:map.keySet()){
                        map.put(ch,map.get(ch)+1);
                    }
                }else{
                    sb.append(s.charAt(i));
                    map.put(s.charAt(i),i);
                }
            }
        }
        return sb.toString();
    }
}