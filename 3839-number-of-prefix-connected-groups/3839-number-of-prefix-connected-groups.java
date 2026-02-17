class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            String st=words[i];
            if(st.length()<k){
                continue;
            }
            String st1=st.substring(0,k);
            map.put(st1,map.getOrDefault(st1,0)+1);
        }
        int ans=0;
        for(int val:map.values()){
            if(val>=2){
                ans++;
            }
        }
        return ans;
    }
}